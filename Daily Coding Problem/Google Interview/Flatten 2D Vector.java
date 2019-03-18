class Main implements Iterator<Integer> {
    int x;
    int y;
    List<List<Integer>> vec2d;

    public Main(List<List<Integer>> vec2d) {
        y = 0;
        x = 0;
        this.vec2d = vec2d;
    }

    @Override
    public Integer next() {
        return vec2d.get(y).get(x++);
    }

    @Override
    public boolean hasNext() {
        while (y < vec2d.size()) {
            if (x < vec2d.get(y).size()) {
                return true;
            } else {
                y++;
                x = 0;
            }
        }
        return false;
    }
}