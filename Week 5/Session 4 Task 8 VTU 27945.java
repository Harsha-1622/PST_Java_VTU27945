import java.util.*;

class Solution {

    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> result = new ArrayList<>();

        for (String word : words) {

            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean matches(String word, String pattern) {

        HashMap<Character, Character> map1 = new HashMap<>();

        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            char p = pattern.charAt(i);
            char w = word.charAt(i);

            if (map1.containsKey(p)) {
                if (map1.get(p) != w) {
                    return false;
                }
            } else {
                map1.put(p, w);
            }

            if (map2.containsKey(w)) {
                if (map2.get(w) != p) {
                    return false;
                }
            } else {
                map2.put(w, p);
            }
        }

        return true;
    }
}

Output:
words = ["abc","deq","mee","aqq","dkd","ccc"]
pattern = "abb"
["mee","aqq"]
