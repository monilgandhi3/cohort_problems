class Solution {
    public int largestUniqueNumber(int[] nums) {
        int result = -1;
        if(nums.length <= 0) {
            return result;
        }
        
        HashSet<Integer> singleOccurrence = new HashSet<>();
        HashSet<Integer> multiOccurrence = new HashSet<>();
        for(int i: nums) {
            if(!singleOccurrence.contains(i) && !multiOccurrence.contains(i)) {
                singleOccurrence.add(i);
            } else {
                multiOccurrence.add(i);
                singleOccurrence.remove(i);
            }
        }
        
        int max = -1;
        for(int j: singleOccurrence) {
            if(j > max) {
                max = j;
            }
        }
        
        return max;
    }
}