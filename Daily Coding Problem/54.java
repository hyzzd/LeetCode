class Main {
    static class Sudoku {

        public static final int[][] GRID_TO_SOLVE = { { 9, 0, 0, 1, 0, 0, 0, 0, 5 }, { 0, 0, 5, 0, 9, 0, 2, 0, 1 },
                { 8, 0, 0, 0, 4, 0, 0, 0, 0 }, { 0, 0, 0, 0, 8, 0, 0, 0, 0 }, { 0, 0, 0, 7, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 2, 6, 0, 0, 9 }, { 2, 0, 0, 3, 0, 0, 0, 0, 6 }, { 0, 0, 0, 2, 0, 0, 9, 0, 0 },
                { 0, 0, 1, 9, 0, 4, 5, 7, 0 }, };

        private int[][] board;
        public static final int EMPTY = 0; // empty cell
        public static final int SIZE = 9; // size of our Sudoku grids

        public Sudoku(int[][] board) {
            this.board = new int[SIZE][SIZE];

            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    this.board[i][j] = board[i][j];
                }
            }
        }

        // we check if a possible number is already in a row
        private boolean isInRow(int row, int number) {
            for (int i = 0; i < SIZE; i++)
                if (board[row][i] == number)
                    return true;

            return false;
        }

        // we check if a possible number is already in a column
        private boolean isInCol(int col, int number) {
            for (int i = 0; i < SIZE; i++)
                if (board[i][col] == number)
                    return true;

            return false;
        }

        // we check if a possible number is in its 3x3 box
        private boolean isInBox(int row, int col, int number) {
            int r = row - row % 3;
            int c = col - col % 3;

            for (int i = r; i < r + 3; i++)
                for (int j = c; j < c + 3; j++)
                    if (board[i][j] == number)
                        return true;

            return false;
        }

        // combined method to check if a number possible to a row,col position is ok
        private boolean isOk(int row, int col, int number) {
            return !isInRow(row, number) && !isInCol(col, number) && !isInBox(row, col, number);
        }

        // Solve method. We will use a recursive BackTracking algorithm.
        // we will see better approaches in next video :)
        public boolean solve() {
            for (int row = 0; row < SIZE; row++) {
                for (int col = 0; col < SIZE; col++) {
                    // we search an empty cell
                    if (board[row][col] == EMPTY) {
                        // we try possible numbers
                        for (int number = 1; number <= SIZE; number++) {
                            if (isOk(row, col, number)) {
                                // number ok. it respects sudoku constraints
                                board[row][col] = number;

                                if (solve()) { // we start backtracking recursively
                                    return true;
                                } else { // if not a solution, we empty the cell and we continue
                                    board[row][col] = EMPTY;
                                }
                            }
                        }

                        return false; // we return false
                    }
                }
            }

            return true; // sudoku solved
        }

        public void display() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    System.out.print(" " + board[i][j]);
                }

                System.out.println();
            }

            System.out.println();
        }

        public static void main(String[] args) {
            Sudoku sudoku = new Sudoku(GRID_TO_SOLVE);
            System.out.println("Sudoku grid to solve");
            sudoku.display();

            // we try resolution
            if (sudoku.solve()) {
                System.out.println("Sudoku Grid solved with simple BT");
                sudoku.display();
            } else {
                System.out.println("Unsolvable");
            }
        }
    }
}

// Dancing Link alg
/*
 * public class DancingLinks{
 * 
 * static final boolean verbose = true;
 * 
 * class DancingNode{ DancingNode L, R, U, D; ColumnNode C;
 * 
 * // hooks node n1 `below` current node DancingNode hookDown(DancingNode n1){
 * assert (this.C == n1.C); n1.D = this.D; n1.D.U = n1; n1.U = this; this.D =
 * n1; return n1; }
 * 
 * // hooke a node n1 to the right of `this` node DancingNode
 * hookRight(DancingNode n1){ n1.R = this.R; n1.R.L = n1; n1.L = this; this.R =
 * n1; return n1; }
 * 
 * void unlinkLR(){ this.L.R = this.R; this.R.L = this.L; updates++; }
 * 
 * void relinkLR(){ this.L.R = this.R.L = this; updates++; }
 * 
 * void unlinkUD(){ this.U.D = this.D; this.D.U = this.U; updates++; }
 * 
 * void relinkUD(){ this.U.D = this.D.U = this; updates++; }
 * 
 * public DancingNode(){ L = R = U = D = this; }
 * 
 * public DancingNode(ColumnNode c){ this(); C = c; } }
 * 
 * class ColumnNode extends DancingNode{ int size; // number of ones in current
 * column String name;
 * 
 * public ColumnNode(String n){ super(); size = 0; name = n; C = this; }
 * 
 * void cover(){ unlinkLR(); for(DancingNode i = this.D; i != this; i = i.D){
 * for(DancingNode j = i.R; j != i; j = j.R){ j.unlinkUD(); j.C.size--; } }
 * header.size--; // not part of original }
 * 
 * void uncover(){ for(DancingNode i = this.U; i != this; i = i.U){
 * for(DancingNode j = i.L; j != i; j = j.L){ j.C.size++; j.relinkUD(); } }
 * relinkLR(); header.size++; // not part of original } }
 * 
 * private ColumnNode header; private int solutions = 0; private int updates =
 * 0; private SolutionHandler handler; private List<DancingNode> answer;
 * 
 * // Heart of the algorithm private void search(int k){ if (header.R ==
 * header){ // all the columns removed if(verbose){
 * System.out.println("-----------------------------------------");
 * System.out.println("Solution #" + solutions + "\n"); }
 * handler.handleSolution(answer); if(verbose){
 * System.out.println("-----------------------------------------"); }
 * solutions++; } else{ ColumnNode c = selectColumnNodeHeuristic(); c.cover();
 * 
 * for(DancingNode r = c.D; r != c; r = r.D){ answer.add(r);
 * 
 * for(DancingNode j = r.R; j != r; j = j.R){ j.C.cover(); }
 * 
 * search(k + 1);
 * 
 * r = answer.remove(answer.size() - 1); c = r.C;
 * 
 * for(DancingNode j = r.L; j != r; j = j.L){ j.C.uncover(); } } c.uncover(); }
 * }
 * 
 * private ColumnNode selectColumnNodeNaive(){ return (ColumnNode) header.R; }
 * 
 * private ColumnNode selectColumnNodeHeuristic(){ int min = Integer.MAX_VALUE;
 * ColumnNode ret = null; for(ColumnNode c = (ColumnNode) header.R; c != header;
 * c = (ColumnNode) c.R){ if (c.size < min){ min = c.size; ret = c; } } return
 * ret; }
 * 
 * // Ha, another Knuth algorithm private ColumnNode selectColumnNodeRandom(){
 * // select a column randomly ColumnNode ptr = (ColumnNode) header.R;
 * ColumnNode ret = null; int c = 1; while(ptr != header){ if(Math.random() <=
 * 1/(double)c){ ret = ptr; } c++; ptr = (ColumnNode) ptr.R; } return ret; }
 * 
 * private ColumnNode selectColumnNodeNth(int n){ int go = n % header.size;
 * ColumnNode ret = (ColumnNode) header.R; for(int i = 0; i < go; i++) ret =
 * (ColumnNode) ret.R; return ret; }
 * 
 * private void printBoard(){ // diagnostics to have a look at the board state
 * System.out.println("Board Config: "); for(ColumnNode tmp = (ColumnNode)
 * header.R; tmp != header; tmp = (ColumnNode) tmp.R){
 * 
 * for(DancingNode d = tmp.D; d != tmp; d = d.D){ String ret = ""; ret +=
 * d.C.name + " --> "; for(DancingNode i = d.R; i != d; i = i.R){ ret +=
 * i.C.name + " --> "; } System.out.println(ret); } } }
 * 
 * // grid is a grid of 0s and 1s to solve the exact cover for // returns the
 * root column header node private ColumnNode makeDLXBoard(int[][] grid){ final
 * int COLS = grid[0].length; final int ROWS = grid.length;
 * 
 * ColumnNode headerNode = new ColumnNode("header"); ArrayList<ColumnNode>
 * columnNodes = new ArrayList<ColumnNode>();
 * 
 * for(int i = 0; i < COLS; i++){ ColumnNode n = new
 * ColumnNode(Integer.toString(i)); columnNodes.add(n); headerNode =
 * (ColumnNode) headerNode.hookRight(n); } headerNode = headerNode.R.C;
 * 
 * for(int i = 0; i < ROWS; i++){ DancingNode prev = null; for(int j = 0; j <
 * COLS; j++){ if (grid[i][j] == 1){ ColumnNode col = columnNodes.get(j);
 * DancingNode newNode = new DancingNode(col); if (prev == null) prev = newNode;
 * col.U.hookDown(newNode); prev = prev.hookRight(newNode); col.size++; } } }
 * 
 * headerNode.size = COLS;
 * 
 * return headerNode; }
 * 
 * private void showInfo(){ System.out.println("Number of updates: " + updates);
 * }
 * 
 * // Grid consists solely of 1s and 0s. Undefined behaviour otherwise public
 * DancingLinks(int[][] grid){ this(grid, new DefaultHandler()); }
 * 
 * public DancingLinks(int[][] grid, SolutionHandler h){ header =
 * makeDLXBoard(grid); handler = h; }
 * 
 * public void runSolver(){ solutions = 0; updates = 0; answer = new
 * LinkedList<DancingNode>(); search(0); if(verbose) showInfo(); }
 * 
 * }
 */