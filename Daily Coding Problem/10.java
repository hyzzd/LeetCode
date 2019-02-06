class Main {
    public void setTimeout(Runnable runnable, int delay) {
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            } catch (Exception e) {
                System.err.println(e);
            }
        }).start();
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.setTimeout(() -> System.out.println("test"), 1000);
        System.out.println("Hello World!");
    }
}