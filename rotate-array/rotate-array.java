class Solution {
    public void rotate(int[] nums, int k) {
        // rotate entire array
        // find the split point with nums.length - k - 1
        // rotate one half of the part excluding split
        // rotate second half of the part including split
        
        if (nums == null || nums.length < 2 || nums.length == k || k <= 0 ){
            return;
        }
        
        int trimmedK = k > nums.length ? k % nums.length : k;
        
        rotateInternal(0, nums.length - 1, nums);
        rotateInternal(0, trimmedK - 1, nums);
        rotateInternal(trimmedK, nums.length - 1, nums);    
    }
    
    private void rotateInternal(int startIndex, int endIndex, int[] nums) {
        while(startIndex < endIndex) {
            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
            ++startIndex;
            --endIndex;
        }
    }
}