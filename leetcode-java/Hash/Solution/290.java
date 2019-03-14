/**
 * 290. Word Pattern

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */

class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null && str == null) {
            return true;
        }
        if (pattern == null || str == null) {
            return false;
        }

        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!map1.containsKey(c) && !map2.containsKey(strs[i])) {
                map1.put(c, strs[i]);
                map2.put(strs[i], c);
            } else if (!strs[i].equals(map1.get(c)) || c != map2.get(strs[i])) {
                return false;
            }
        }
        return true;
    }
}