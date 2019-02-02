class Main {
    public void powerSet(char[] set, int size){
        long powSize = (long)Math.pow(2, size);
        
        for(int count = 0; count < powSize; count++){
            for(int j = 0; j < size; j++){
                if((count & (1 << j)) > 0)
                    System.out.print(set[j]);
            }
            System.out.println(); 
        }
    }
    public static void main(String[] args) {
        Main m = new Main();
        char[] set = {'a', 'b', 'c'};
        m.powerSet(set, set.length);
        System.out.println("Hello World!");
    }
}