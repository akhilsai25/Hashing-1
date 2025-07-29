// This algorithm uses two data structures. One array that stores the mapping from s to t and another that stores the boolean whether t char was previously noticed. If a char is not found on the s to t mapping it indirectly means that t char should not be available from t to s mapping irrespective of what it maps to 
class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] sMap = new char[95];
        boolean[] tMap = new boolean[95];

        for(int i=0;i<s.length();i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // Check if the char s is not available yet
            if(sMap[sChar-' ']==0) {
                // If t char is found before then there is mapping issue
                if(tMap[tChar-' ']==true) return false;
                // Set the found mappings
                sMap[sChar-' '] = tChar;
                tMap[tChar-' '] = true;
            } else {
                // If the s to t mapping is wrong, return false
                if(tChar != sMap[sChar-' ']) return false;
            }
        }
        return true;
    }
}
