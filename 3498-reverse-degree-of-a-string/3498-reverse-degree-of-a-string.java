class Solution {
    public int reverseDegree(String s) {
        int totalSum = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int reversedAlphabetIndex = 'z' - c + 1;
            int stringIndex = i + 1;
            
            totalSum += reversedAlphabetIndex * stringIndex;
        }
        
        return totalSum;
    }
}