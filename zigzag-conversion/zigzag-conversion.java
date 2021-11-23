class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        
        List<StringBuilder> sbList = new ArrayList<StringBuilder>();
        for(int idx = 0; idx <numRows; idx++){
            sbList.add(new StringBuilder());
        }
        
        boolean goingUp = true;
        int currentRow = 0;
        for(int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if(goingUp) {
                sbList.get(currentRow++).append(currentChar);    
            } else {
                sbList.get(currentRow--).append(currentChar);
            }
            goingUp = currentRow >= numRows-1 || currentRow == 0 ? !goingUp : goingUp;
        }
        
        StringBuilder result = new StringBuilder();
        for(StringBuilder sb : sbList) {
            result.append(sb.toString());
        }
        
        return result.toString();
    }
}