package DSA_Java.DataStructure.Heap;
import java.util.*;

import DSA_Java.DataStructure.Tree.BinaryTree;
import DSA_Java.DataStructure.Tree.TreeNode;

public class Heap {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1); // Initialize the root node
        BinaryTree.insert(root, 2);
        BinaryTree.insert(root, 3);
        
        BinaryTree.levelOrderTraversal(root);
    }
}



class KthLargest {
    private int k;
    private ArrayList<Integer> heap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i : nums){
            heap.add(i);
            heapifyUp(heap.size() - 1);
        }
    }

    // public void buildHeap(){
    //     for(int i = nums.size()/2 -1 ; i >= 0 ; i--){

    //     }
    // }
    
    public int add(int val) {
        // insert
        heap.add(val);
        // heapify
        heapifyUp(heap.size()-1);
        // search kth element       
        
        return findKthLargest();
    }

    public int findKthLargest(){
        // Min-heap để theo dõi k phần tử lớn nhất
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // Duyệt qua toàn bộ max-heap
        for (int value : heap) {
            if (minHeap.size() < k) {
                minHeap.add(value);
            } else if (value > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(value);
            }
        }

        // Kết quả là phần tử nhỏ nhất trong min-heap
        return minHeap.peek();
    }
    private void heapifyUp(int index){
        while(index > 0){
            int parentIndex = (index-1)/2;
            
            if(heap.get(parentIndex) >= heap.get(index)) break;

            // swap
            int temp = heap.get(parentIndex);
            heap.set(parentIndex,heap.get(index));
            heap.set(index, temp);

            index = parentIndex;
        }
    }
}



class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // sử dụng min heap 
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for(int[] point : points){
            int distance = point[0]*point[0] + point[1]*point[1];
            minHeap.offer(new int[]{distance,point[0],point[1]});
        }

        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++){
            int[] point = minHeap.poll();
            result[i] = new int[]{point[1],point[2]};
        }
        return result;
    }


    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> frequency = new HashMap<>();
        for(char task : tasks){
            frequency.put(task,frequency.getOrDefault(task,0)+1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.addAll(frequency.values());

        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            if(!queue.isEmpty() && queue.peek()[1] <= time){
                maxHeap.offer(queue.poll()[0]);
            }
            if(!maxHeap.isEmpty()){
                int cnt = maxHeap.poll() - 1;
                if(cnt > 0){
                    queue.offer(new int[]{cnt,time + n + 1});
                }
            }
            time++;
        }
        return time;
    }
}


class Twitter {
    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
    }
    
    public void follow(int followerId, int followeeId) {
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        
    }
}