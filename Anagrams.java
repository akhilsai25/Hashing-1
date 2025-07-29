// This algorithm uses the map wit double as the key and list of strings as the values. Key maps to the custom hash value generated using the prime numbers with the assumption that product of prime will always remaing same and wont be conflicted.
class Solution {
    int[] primes = new int[26];
    public List<List<String>> groupAnagrams(String[] strs) {
        loadPrimes();
        Map<Double, List<String>> map = new HashMap();
        // o(n)
        for(String str:strs) {
            double hash = getHash(str);
            if(!map.containsKey(hash)) {
                // o(k) - for iterating over string to generate the hash
                map.put(hash, new ArrayList());
            }
            map.get(hash).add(str);
        }

        return new ArrayList(map.values());
    }

    // get hash for a given number
    private double getHash(String s) {
        double response = 1;
        for(int i=0;i<s.length();i++) {
            response*=primes[s.charAt(i)-'a'];
        }
        return response;
    }

    // load the required prime numbers
    private void loadPrimes() {
        int j = 2;
        for(int i=0;i<26;i++) {
            while(!checkPrime(j)) {
                j++;
            }
             primes[i] = j++;
        }
    }

    // check if a number is prime
    private boolean checkPrime(int n) {
        for(int i=2;i<=Math.sqrt(n);i++) {
            if(n%i==0) return false;
        }
        return true;
    }
}
