class Main {
    public int random(int n, int[] list){
        // Assume rand(n) generate uniform numbers from 0 to n-1
        int result = rand(n);
        while(inList(result, list)){
            result = rand(n);
        }
        return result;
    }
    
    private int rand(int n) {
        return 0;
    }

    public boolean inList(int n, int[] list) {
        int left = 0, right = list.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
        
            if(list[mid] < n){
                left = mid;
            }else if(list[mid] > n){
                right = mid;
            }else{
                return true;
            }
        }
        
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}