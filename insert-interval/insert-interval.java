
class Solution {
    LinkedList<int[]> intervalList = new LinkedList();
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) {
            intervals = new int[1][];
            intervals[0] = newInterval;
            return intervals;
        }
        
        intervalList = new LinkedList();
        boolean intervalAdded = false;
        // when can it not be merged
        // if new intervals start time is greater than the end time of the 
    
        for(int[] interval: intervals) {
            if(newInterval[0] < interval[0]) {
                // add the new interval
                MergeIntervalsIfPossible(newInterval);
                intervalAdded = true;
            }
            
            MergeIntervalsIfPossible(interval);
        }
        
        if(!intervalAdded) {
            MergeIntervalsIfPossible(newInterval);
        }
        return intervalList.toArray(new int[intervalList.size()][]);
    }
    
    private void MergeIntervalsIfPossible(int[] interval) {
        if(!intervalList.isEmpty() && intervalList.getLast()[1] >= interval[0]) {
            // merge here
            intervalList.getLast()[1] = Math.max(intervalList.getLast()[1], interval[1]);
        } else
        {
            // no merge
            intervalList.add(interval);
        }
    }
}
