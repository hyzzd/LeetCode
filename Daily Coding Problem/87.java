import java.util.HashMap;
import java.util.Map;

class Main {
    public static class Pos{
        int x;
        int y;
        
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    private static int[] x = new int[] {-1,0,1,1,1,0,-1,-1}; // 8 directions
    private static int[] y = new int[] {-1,-1,-1,0,1,1,1,0};
    
    public static boolean validation(int[][] rul){
        // first, assume the rules are sorted
        Map<Integer, Pos> nod = new HashMap<>(); // use to save nodes in rules

        int n = rul.length; // how many rules, rule = [1, 0, 2] - A NW B
        int[][] mat = new int[2*n - 1][2*n - 1]; // create a map for checking
        for(int i = 0; i < n; ++i){     // loop through all rules
            if(i == 0){                 // first rule place it in the middle of map
                nod.put(rul[i][0], new Pos(n/2, n/2));  // store the node with its position
                mat[n/2][n/2] = 1;
                nod.put(rul[i][2], new Pos(n/2 + x[rul[i][1]], n/2 + y[rul[i][1]]));  // assume two nodes are different
                mat[n/2 + x[rul[i][1]]][n/2 + y[rul[i][1]]] = 1;
            }else if(canPlace(mat, nod, rul[i])){
                if(!nod.containsKey(rul[i][0])){
                    nod.put(rul[i][0], new Pos(nod.get(rul[i][2]).x + x[rul[i][1]], nod.get(rul[i][2]).y + y[rul[i][1]]));
                    mat[nod.get(rul[i][2]).x + x[rul[i][1]]][nod.get(rul[i][2]).y + y[rul[i][1]]] = 1;
                }else{
                    nod.put(rul[i][2], new Pos(nod.get(rul[i][0]).x + x[rul[i][1]], nod.get(rul[i][0]).y + y[rul[i][1]]));
                    mat[nod.get(rul[i][0]).x + x[rul[i][1]]][nod.get(rul[i][0]).y + y[rul[i][1]]] = 1;
                }
            }else{
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean canPlace(int[][] mat, Map<Integer, Pos> nod, int[] rul){
        if(!nod.containsKey(rul[0])){
            mat[nod.get(rul[2]).x + x[rul[1]]][nod.get(rul[2]).y + y[rul[1]]] = 1;
        }else if(!nod.containsKey(rul[2])){
            mat[nod.get(rul[0]).x + x[rul[1]]][nod.get(rul[0]).y + y[rul[1]]] = 1;
        }else{
            if(rul[1] == 1 && (nod.get(rul[0]).y < nod.get(rul[2]).y)){
                return true;
            }else if(rul[1] == 3 && (nod.get(rul[0]).x > nod.get(rul[2]).x)){
                return true;
            }else if(rul[1] == 5 && (nod.get(rul[0]).y > nod.get(rul[2]).y)){
                return true;
            }else if(rul[1] == 7 && (nod.get(rul[0]).x < nod.get(rul[2]).x)){
                return true;
            }else if(nod.get(rul[0]).x + x[rul[1]] == nod.get(rul[2]).x && nod.get(rul[0]).y + y[rul[1]] == nod.get(rul[2]).y){
                return true;
            }                   
        }        
        
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}