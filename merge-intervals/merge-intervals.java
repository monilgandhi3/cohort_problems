class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals[0].length == 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
            
        LinkedList<int[]> result = new LinkedList();
        for(int[] interval : intervals){
            if(result.isEmpty() || result.getLast()[1] < interval[0]){
                // no merge add to the list
                result.add(interval);
            } else {
                result.getLast()[1] = Math.max(interval[1], result.getLast()[1]);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}