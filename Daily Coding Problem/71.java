class Main {
    public int rand5(){
        int i = rand7();
        while(i > 5){
            i = rand7();
        }
        
        return i;
    }
    
    private int rand7() {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}