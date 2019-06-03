import java.util.*;

class Main {
    public static void sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);

        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a prime
            if (prime[p] == true) {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        // Print all prime numbers
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true)
                System.out.print(i + " ");
        }
    }

    public static void printPrimes() {
        int first = 2;
        List<Integer> seen = new ArrayList<>();
        seen.add(first);
        System.out.println(first);

        Generator<Integer> infiniteGenerator = new Generator<Integer>() {
            public void run() throws InterruptedException {
                int num = seen.get(seen.size() - 1) + 1;
                while (true) {
                    boolean sieve = true;
                    for (int k = 0; k < seen.size(); k++) {
                        if (num % seen.get(k) != 0) {
                            sieve = false;
                            break;
                        }
                    }
                    if (sieve) {
                        Thread.sleep(100);
                        yield(num);
                    }

                    num += 1;
                }
            }
        };
        for (Integer prime : infiniteGenerator) {
            seen.add(prime);
            System.out.println(prime);
        }
    }

    public static void main(String[] args) {
        printPrimes();
    }
}

abstract class Generator<T> implements Iterable<T> {

    private class Condition {
        private boolean isSet;

        public synchronized void set() {
            isSet = true;
            notify();
        }

        public synchronized void await() throws InterruptedException {
            try {
                if (isSet)
                    return;
                wait();
            } finally {
                isSet = false;
            }
        }
    }

    static ThreadGroup THREAD_GROUP;

    Thread producer;
    private boolean hasFinished;
    private final Condition itemAvailableOrHasFinished = new Condition();
    private final Condition itemRequested = new Condition();
    private T nextItem;
    private boolean nextItemAvailable;
    private RuntimeException exceptionRaisedByProducer;

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return waitForNext();
            }

            @Override
            public T next() {
                if (!waitForNext())
                    throw new NoSuchElementException();
                nextItemAvailable = false;
                return nextItem;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            private boolean waitForNext() {
                if (nextItemAvailable)
                    return true;
                if (hasFinished)
                    return false;
                if (producer == null)
                    startProducer();
                itemRequested.set();
                try {
                    itemAvailableOrHasFinished.await();
                } catch (InterruptedException e) {
                    hasFinished = true;
                }
                if (exceptionRaisedByProducer != null)
                    throw exceptionRaisedByProducer;
                return !hasFinished;
            }
        };
    }

    protected abstract void run() throws InterruptedException;

    protected void yield(T element) throws InterruptedException {
        nextItem = element;
        nextItemAvailable = true;
        itemAvailableOrHasFinished.set();
        itemRequested.await();
    }

    private void startProducer() {
        assert producer == null;
        if (THREAD_GROUP == null)
            THREAD_GROUP = new ThreadGroup("generatorfunctions");
        producer = new Thread(THREAD_GROUP, new Runnable() {
            @Override
            public void run() {
                try {
                    itemRequested.await();
                    Generator.this.run();
                } catch (InterruptedException e) {
                    // No need to do anything here; Remaining steps in run()
                    // will cleanly shut down the thread.
                } catch (RuntimeException e) {
                    exceptionRaisedByProducer = e;
                }
                hasFinished = true;
                itemAvailableOrHasFinished.set();
            }
        });
        producer.setDaemon(true);
        producer.start();
    }

    @Override
    protected void finalize() throws Throwable {
        producer.interrupt();
        producer.join();
        super.finalize();
    }
}