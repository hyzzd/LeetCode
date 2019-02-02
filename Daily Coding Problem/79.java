class Main {
    public static boolean checkPossibility(int[] arr){
        int p = -1;
        for(int i = 0; i < arr.length - 1; ++i){
            if(arr[i] > arr[i + 1]){
                if(p != -1) return false;
                p = i;
            }
        }
        
        return p == -1 || p == 0 || p == arr.length - 2 || arr[p - 1] <= arr[p + 1] || arr[p] <= arr[p + 2];
    }
    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{4,2,3}));
    }
}