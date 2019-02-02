import java.util.Collections;
import java.util.PriorityQueue;

class Main {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    
    public Main(){
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num){
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        
        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian(){
        if(maxHeap.size() == minHeap.size()){
            return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        }else{
            return maxHeap.peek();
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}