import java.util.HashSet;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        int[] array = new int[]{10, 15, 3, 7};
        System.out.println(twoSum(array, 17));
    }
    public static boolean twoSum(int[] arr, int k){
        Set<Integer> hashset = new HashSet<>();
        for(int n : arr){
            if(hashset.contains(k - n)){
                return true;
            }
            hashset.add(n);
        }
        return false;
    }
}