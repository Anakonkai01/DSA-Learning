package DSA_Java.Algorithms.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class BackTracking {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list1 = new ArrayList<>();
        
        permutation(nums, 0, nums.length - 1,list1);
        
        return list1;
    }

    public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> subsets = new ArrayList<>();
            dfs(res, subsets, nums, 0);
            return res;
        }
    
        private void dfs(List<List<Integer>> res, List<Integer> subset, int[]nums, int index){
            if(index >= nums.length){
                res.add(new ArrayList<>(subset)); // phải tạo đối tượng mới, mọi đối tượng trong res vẫn là subset(luôn bị thay đổi)
                return;
            }
    
            subset.add(nums[index]); // lựa chọn thêm vào
            dfs(res, subset, nums, index + 1);
    
            
            subset.remove(subset.size() - 1); // lựa chọn ko thêm vào
            dfs(res, subset, nums, index + 1); // quay lui
        }
    
        


    private void permutation(int[] nums, int l, int r, List<List<Integer>> list){
        if(l == r){
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            list.add(permutation);
        }
        else{
            for(int i = l; i <= r; i++){
                swap(nums, l, i);
                permutation(nums, l+1, r, list);
                swap(nums, l, i);
            }
        }
    }

    private int[] swap (int[] list, int l, int r){
        int temp = list[l];
        list[l] = list[r];
        list[r] = temp;
        return list;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        BackTracking backTracking = new BackTracking();

        System.out.println(backTracking.subsets(nums));
    }
}
