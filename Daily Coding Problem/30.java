class Main {
    public int unitWater(int[] arr){
        if(arr == null || arr.length == 0)
            return 0;
        
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        int temp = 0;
        for(int i = 1; i < n - 1; ++i){
            if(arr[i - 1] > temp){
                temp = arr[i - 1];
            }
            left[i] = temp;
        }
        
        temp = 0;
        for(int i = n - 2; i > 0; --i){
            if(arr[i + 1] > temp){
                temp = arr[i + 1];
            }
            right[i] = temp;
        }
        
        int result = 0;
        for(int i = 1; i < n - 1; ++i){
            result += Math.min(left[i], right[i]) - arr[i];
        }
        
        return result;
    }
    public static void main(String[] args) {
        Main m = new Main();
        
        System.out.println(m.unitWater(new int[]{3, 0, 1, 3, 0, 5}));
    }
}