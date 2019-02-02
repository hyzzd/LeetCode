class Main {
    public static int findNth(int n){
        int count = 0;
        for(int curr = 19; ; curr += 9){
            /* works for other numbers also
            int sum = 0;
            for(int x = curr; x > 0; x /= 10){
                sum += x % 10;
            }
            if(sum == 10){
                count++;
            }
            */
            count++;
            if(count == n)
                return curr;
        }
    }
    public static void main(String[] args) {
        System.out.println(findNth(5));
    }
}