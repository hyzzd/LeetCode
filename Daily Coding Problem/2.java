class Main {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};
        int[] arr = mutiplyArr(array);
        for(int i : arr){
            System.out.println(i);
        }
        
    }
    public static int[] mutiplyArr(int[] arr){
        int[] newArr = new int[arr.length];
        int temp = 1;
        for(int i = 0; i < arr.length; ++i){
            newArr[i] = temp;
            temp *= arr[i];
        }
        temp = 1;
        for(int i = arr.length - 1; i >= 0; --i){
            newArr[i] *= temp;
            temp *= arr[i];
        }
        
        return newArr;
    }
}