class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> knowledgeMap = new HashMap<>();
        
        for(int j = 0; j < knowledge.size();j++) {
            knowledgeMap.put(knowledge.get(j).get(0), knowledge.get(j).get(1));
        }
        
        StringBuilder result = new StringBuilder();
        StringBuilder key = new StringBuilder();
        
        boolean bracketStart = false;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                bracketStart = true;
            } else if (s.charAt(i) == ')') {
                bracketStart = false;
                result.append(knowledgeMap.getOrDefault(key.toString(), "?"));
                key.setLength(0);
            } else if(bracketStart) {
                key.append(s.charAt(i));
            } else {
                result.append(s.charAt(i));
            }
            
            
            
            
        }
        
        return result.toString();
    }
}