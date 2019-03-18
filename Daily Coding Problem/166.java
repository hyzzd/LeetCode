class Main {
    private int[][] Array2D;
    private int pos = 0; // The position of our cursor
    private List list;// What we are going to return
    private int maxIterations;
    private boolean shouldRemove;
    private final int firstIndex = 0;

    public Main(int[][] Array2D) {
        this.Array2D = Array2D;
        this.shouldRemove = false;
        copyArray(Array2D);
    }

    @Override
    public Integer next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        // Get value then remove it from the list
        Integer result = (Integer) list.get(firstIndex);
        pos++;
        shouldRemove = true; // Remove values from the List
        remove();
        return result;
    }

    @Override
    public boolean hasNext() {
        return pos < maxIterations; // Start at 0 and move up
    }

    private void copyArray(int[][] array) {
        list = new ArrayList<Integer>();

        // Loop though all values
        for (int[] data : array) {
            for (int val : data) {
                list.add(val);
            }
        }

        // Set total number of iterations
        setMaxIterations(getList());
    }

    private void setMaxIterations(List list) {
        if (list != null) {
            maxIterations = list.size();
        }
    }

    private void remove() {
        if (shouldRemove) {
            list.remove(firstIndex);
            shouldRemove = false;
        }
    }
}