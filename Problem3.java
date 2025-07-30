// This algorithm offers structure where we maintain one map from pattern to s mapping and another set to check if the element from the string already existed before. 
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap();
        Set<String> set = new HashSet();
        String[] splitt = s.split(" ");
        if(splitt.length!=pattern.length()) return false;
        for(int i=0;i<pattern.length();i++) {
            char c = pattern.charAt(i);
            String sp = splitt[i];
            // If the character already existed, check whether mapping is according to expectation and return false if not
            if(map.containsKey(c)) {
                if(!map.get(c).equals(sp)) return false;
            } else {
                // If the character does not exist, we check if the value is present in the hash set and cross check
                if(set.contains(sp)) return false;
                set.add(sp);
                map.put(c, sp);
            }
        }
        return true;
    }
}
