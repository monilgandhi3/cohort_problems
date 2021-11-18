class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(Arrays.asList(1));
        if(numRows <= 1) 
            return result;
        
        result.add(Arrays.asList(1,1));

        int startRow = 3;
        List<Integer> previousRow = result.get(result.size() - 1);
        while(startRow <= numRows) {
            List<Integer> intResult = new ArrayList<Integer>();
            intResult.add(1);
            
            for(int i = 1; i < previousRow.size(); i++)
                intResult.add(previousRow.get(i-1) + previousRow.get(i));
            
            intResult.add(1);
            result.add(intResult);
            previousRow = intResult;
            ++startRow;
        }
        
        return result;
    }
}