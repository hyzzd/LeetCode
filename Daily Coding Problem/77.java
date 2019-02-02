import java.util.Arrays;
import java.util.Comparator;

class Main {
    public static void mergeIntervals(Interval[] arr) {
        Arrays.sort(arr, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                return i1.start-i2.start;
            }
        });
        
        int index = 0;
        for(int i = 0; i < arr.length; ++i) {
            if(index != 0 && arr[index - 1].end > arr[i].start) {
                while(index != 0 && arr[index-1].end > arr[i].start){
                    arr[index - 1].end = Math.max(arr[index - 1].end, arr[i].end);
                    arr[index - 1].start = Math.min(arr[index - 1].start, arr[i].start);
                    index--;
                }
            }else{
                arr[index] = arr[i];
            }
            index++;
        }
        
        for(int i = 0; i < index; ++i){
            System.out.println("[" + arr[i].start + "," + arr[i].end + "]");
        }
    }
    public static void main(String[] args) {
        Interval arr[]=new Interval[4]; 
        arr[0]=new Interval(1,3); 
        arr[1]=new Interval(5,8); 
        arr[2]=new Interval(4,10); 
        arr[3]=new Interval(20,25); 
        mergeIntervals(arr); 
    }
}

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}