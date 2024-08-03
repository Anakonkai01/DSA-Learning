package DSA_Java.DataStructure.Heap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import DSA_Java.DataStructure.Tree.BinaryTree;
import DSA_Java.DataStructure.Tree.TreeNode;

public class MaxHeap {
    private ArrayList<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    // Phương thức chèn một phần tử vào heap
    public void insert(int data){
        heap.add(data);
        int index = heap.size() - 1;
        heapifyUp(index);
    }

    private void heapifyUp(int index){
        while(index > 0){
            int parentIndex = (index - 1)/2;

            if(heap.get(index) <= heap.get(parentIndex)){
                break;
            }

            // swap
            int temp = heap.get(parentIndex);
            heap.set(parentIndex,heap.get(index));
            heap.set(index, temp);

            // cap nhap index len thanh cha
            index = parentIndex;
        }
        
    }


    public void deleteRoot(){
        if(heap.size() == 0){
            throw new IllegalStateException("Heap is Empty");
        }
        // hoan doi root voi phan tu cuoi cung
        
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1); // xoas phan tu cuoi cung 

        if(heap.size() > 0){
            heapifyDown(0); // heapify tu root
        }
                
    }

    private void heapifyDown(int index){
        int size = heap.size();
        int largest = index;
        int left = 2*index + 1;
        int right = 2*index + 2;

        if(left < size && heap.get(left) > heap.get(largest) ){
            largest = left;
        }
        if(right < size && heap.get(right) > heap.get(largest) ){
            largest = right;
        }
        if(largest != index){
            // swap 
            int temp = heap.get(index);
            heap.set(index, heap.get(largest));
            heap.set(largest,temp);
            // de quy 
            heapifyDown(largest);
        }
    }

    // Phương thức in heap
    public void printHeap() {
        System.out.println(heap);
    }
    
    public boolean contains(int value){
        return heap.contains(value);
    }

    public int getSize(){
        return heap.size();
    }
    
    public boolean isEmpty(){
        return heap.size() == 0;
    }

    public void clear(){
        heap.clear();
    }

    public void buildHeap_FromArray(ArrayList<Integer> list){
        heap = list;
        // i di tu giua vi tu 2i tro di la leafs
        for(int i = (heap.size()/2) - 1; i >= 0; i--){ 
            heapifyDown(i); // heapifydown tu 
        }
    }

    public void replace(int index, int newValue){
        if(index < 0 || index >= heap.size()){
            throw new IllegalStateException("Index out of boundsssssssss");
        }

        int oldValue = heap.get(index);
        if(oldValue > newValue){
            heapifyDown(index);
        }
        else{
            heapifyUp(index);
        }
    }


    public int peek(){
        if(heap.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    public List<Integer> getList(){
        if(heap.size() == 0){
            return null;
        }
        return heap;
    }
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(i+1);
        }
        maxHeap.buildHeap_FromArray(list);
        maxHeap.printHeap();
        maxHeap.clear();
        for(int i = 0; i < 10; i++){
            maxHeap.insert(i+1);
        }
        maxHeap.printHeap();
        
        TreeNode root = new TreeNode();
        // BinaryTree binaryTree = new BinaryTree();
        for(Integer i : maxHeap.getList()){
            BinaryTree.insert(root,i);
        }
        BinaryTree.levelOrderTraversal(root);
        

        
    }
}
