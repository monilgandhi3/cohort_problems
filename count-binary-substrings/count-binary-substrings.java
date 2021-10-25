class Solution {
    public int countBinarySubstrings(String s) {
        
        if(s == null || s.length() < 2)
            return 0;

        int[] binaryOccurrenceArray = new int[2];
        char currentChar = s.charAt(0);
        char previousChar = s.charAt(0);
        binaryOccurrenceArray[currentChar - '0'] = 1;
        int stringIterator = 1;
        int result = 0;
        while(stringIterator < s.length()){
            currentChar = s.charAt(stringIterator++);
            if(currentChar != previousChar) {
                result += 1;
                if(binaryOccurrenceArray[currentChar - '0'] + 1 >= binaryOccurrenceArray[previousChar - '0'] || ( stringIterator < s.length()) && s.charAt(stringIterator) != currentChar) {
                    binaryOccurrenceArray[previousChar - '0'] = 0;
                    previousChar = currentChar;
                }                
            }

            binaryOccurrenceArray[currentChar - '0'] += 1;
        }

        return result;
    }
}