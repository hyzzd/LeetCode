class Main {
    public Pair cons(int a, int b) {
        return new Pair(a, b);
    }

    public int car(Pair pr) {
        return pr.x;
    }

    public int cdr(Pair pr) {
        return pr.y;
    }

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.car(m.cons(3, 4)));
        System.out.println(m.cdr(m.cons(3, 4)));
    }
}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}