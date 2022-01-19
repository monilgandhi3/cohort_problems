class Solution {
    public String restoreString(String s, int[] indices) {
        if(s.length() == 1) {
            return s;
        }
        
        char[] results = new char[s.length()];
        for(int i = 0; i < s.length(); i++) {
            results[indices[i]] = s.charAt(i);
        }
        
        return new String(results);
    }
}