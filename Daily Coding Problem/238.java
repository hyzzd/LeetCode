import java.util.*;

class Main {
    static Map<Integer, Integer> map = new HashMap<>();

    public static void generateDist() {
        for (int i = 0; i < 12; i++) {
            if (!map.containsKey(i)) {
                map.put(i, 0);
            }
            if (i == 10) {
                map.put(i, map.get(i) + 4);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        int sum = 0;
        for (Map.Entry<Integer, Integer> key : map.entrySet()) {
            sum += key.getValue();
        }

        int prev = 0;
        for (Map.Entry<Integer, Integer> key : map.entrySet()) {
            map.put(key.getKey(), prev + (map.get(key.getKey()) / sum));
            prev = map.get(key.getKey());
        }
    }

    public static int getNextCard() {
        Random random = new Random();
        int rand = random.nextInt();
        int l = 0, r = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> key : map.entrySet()) {
            r = key.getValue();
            if (rand >= l && rand <= r)
                return key.getKey();
            l = r;
        }
        return -1;
    }

    public static boolean playTurn(int[] scores, boolean dealer) {
        if (dealer && scores[1] < 16) {
            int next = getNextCard();
            scores[1] += next;
            return scores[1] > 21 ? true : false;
        }

        if (scores[0] < 21) {
            int next1 = getNextCard();
            if (scores[0] + next1 < 22) {
                scores[0] += next1;
            }
        }

        return false;
    }

    public static void play() {
        int[] scores = { 0, 0 };
        boolean win = false;
        boolean dealer = false;
        while (!win) {
            win = playTurn(scores, dealer);
            dealer = !dealer;
            if (scores[1] < scores[0]) {
                System.out.println("Player wins");
                break;
            }
        }
    }
}