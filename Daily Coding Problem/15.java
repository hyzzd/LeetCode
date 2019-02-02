import java.util.Random;

class Main {
    static int res = 0;
    static int count = 0;
    
    public int selectRan(int x){
        count++;
        
        if(count == 1){
            res = x;
        }else{
            Random r = new Random();
            int i = r.nextInt(count);
            
            if(i == count - 1)
                res = x;
        }
        
        return res;
    }
    public static void main(String[] args) {
        Main m = new Main();
        int[] stream = {1, 2, 3, 4};
        for(int i = 0; i < stream.length; ++i){            
            System.out.println(m.selectRan(stream[i]));
        }
    }
}