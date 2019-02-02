class Main {
    public boolean arbitrage(int[][] table){
        int N = table.length;
        
        //Bellman-Ford algorithm
        for(int i = 0; i < N; ++i){
            for(int j = 0; j < N; ++j){
                table[i][j] = (int) -Math.log(1.00 * table[i][j]);
            }
        }
        
        double[] dis = new double[N];
        double[] pre = new double[N];
        
        for(int i = 0; i < N; ++i){
            dis[i] = Double.MAX_VALUE;
            pre[i] = -1;
        }
        
        dis[N] = 0;
        
        for(int k = 0; k < N; ++k){
            for(int i = 0; i < N; ++i){
                for(int j = 0; j < N; ++j){
                    if(dis[i] + table[i][j] < dis[j]){
                        dis[j] = dis[i] + table[i][j];
                        pre[j] = i;
                    }
                }
            }
        }
        
        for(int i = 0; i < N; ++i){
            for(int j = 0; j < N; ++j){
                if(dis[i] + table[i][j] < dis[j]){
                    //node is in the chain
                }
            }
        }
        
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}