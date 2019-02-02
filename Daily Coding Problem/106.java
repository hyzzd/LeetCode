class Main {
    public boolean canJump(int[] nums){
        int lastPos = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--){
            if(i + nums[i] > lastPos){
                lastPos = i;
            }
        }
        
        return lastPos == 0;
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}