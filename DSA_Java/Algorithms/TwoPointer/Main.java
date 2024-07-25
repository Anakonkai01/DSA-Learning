package DSA_Java.Algorithms.TwoPointer;

class TrappingRainWater {
    

    
}



public class Main {
    public static int trap(int[] height) {
        if(height == null || height.length <= 2){
            return 0;
        }
        int water = 0;
        
        // water[i] = minHeigth(maxLeft,maxRight)
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;

        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= maxLeft){
                    maxLeft = height[left];
                }
                else{
                    water += maxLeft - height[left];
                }
                left++;
            }
            else{
                if(height[right] >= maxRight){
                    maxRight = height[right];
                }
                else{
                    water += maxRight - height[right];
                }
                right--;
            }
        }
        return water;
    }
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Amount of water that can be trapped: " + trap(height));
    }
}