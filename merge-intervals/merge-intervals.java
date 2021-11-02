/*First sort the intervals by start time.
     - How to sort them
     - Just start time or does end time also plays importance
     - for instance [1,3], [1,2]
     - Sort it with start time
     - Merge as you go with the following condition
     - previous pointer and current pointer
     - if previous[start] < current[start] // close the previous interval. Make current previous
     [1,2][3,4]
     [1,2] [ 2, 3]
     - if previous[start] <= current[start] and previous[end] <= current[end]// Merge the interval. Make this interval previous interval 
     - if previouse[end] >= current[start] // merge
     - if 
     for merging take the smallest of start and largest of end
     - if 
     [1,2][1,3]; [1,2][2,3]; [1,5][2,4]; [1,3][2,6]; [1,3][2,3]   
*/  
import java.util.Collections;
class Solution {
    public int[][] merge(int[][] intervals) {
        // how to get 2d array length
        if(intervals[0].length == 1){
            return intervals;
        }
        
        // how to do custom sort
        Arrays.sort(intervals, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        
        LinkedList<int[]> merged = new LinkedList<>();
        
        for(int[] interval: intervals) {
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            }
            else
            {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }
}