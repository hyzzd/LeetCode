import java.util.ArrayList;
import java.util.List;

class Main {
    private static class Node{
        int x;
        int y;
        
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int biShop(int N, List<Node> tuples){
        int ans = 0;
        int[][] dpl = new int[N+2][N+2];
        int[][] dpr = new int[N+2][N+2];
        // remind the edges
        for(int i = 0; i < tuples.size(); ++i){
            Node node = tuples.get(i);
            dpl[node.x + 1][node.y + 1] = dpr[node.x + 1][node.y + 1] = 1;
        }
        
        for(int i = 1; i <= N; ++i){
            for(int j = 1; j <= N; ++j){
                if(dpl[i][j] == 1){
                    ans += dpl[i - 1][j - 1];
                    ans += dpr[i - 1][j + 1];
                }
                dpl[i][j] += dpl[i - 1][j - 1];
                dpr[i][j] += dpr[i - 1][j + 1];
            }            
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        Main m = new Main();
        List<Node> list = new ArrayList<>();
        list.add(new Node(0, 0));
        list.add(new Node(1, 2));
        list.add(new Node(2, 2));
        list.add(new Node(4, 0));
        
        System.out.println(m.biShop(5, list));
    }
}