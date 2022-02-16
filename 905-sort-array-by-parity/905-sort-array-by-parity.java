class Solution {
    // use sort
    // nlogn, + O(n) since not in place
    // two pointers. i = first odd, j = first event
    // start with i and j. Keep moving j till i and j are odd/even. Swap them both.move the pointer to next
    public int[] sortArrayByParity(int[] nums) {
        int nextSwap = 0;
        int odd = 0;
        for(; odd < nums.length; odd++) {
            if(nums[odd] % 2 != 0) {
                // found odd. Find the next even
                for(nextSwap = odd + 1; nextSwap < nums.length; nextSwap++) {
                    if(nums[nextSwap] %2 == 0) {
                        int temp = nums[odd];
                        nums[odd] = nums[nextSwap];
                        nums[nextSwap] = temp;
                        break;
                    }
                }
                
                
                if(nextSwap == nums.length - 1) {
                    // nothing found
                    odd = nextSwap;
                }
            }
        }
        
        return nums;
    }
}