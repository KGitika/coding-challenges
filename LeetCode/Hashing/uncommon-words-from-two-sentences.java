// Problem: Uncommon Words from Two Sentences
// URL: https://leetcode.com/problems/uncommon-words-from-two-sentences/


// Time Complexity: O(M+N), where M,N are the lengths of A and B respectively.
// Space Complexity: O(M+N), the space used by count.


class Solution {

    public String[] uncommonFromSentences(String A, String B) {
        // Split both sentences into words
        String[] Aarr = A.split(" ");
        String[] Barr = B.split(" ");

        // Count occurrences of each word using a HashMap
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : Aarr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : Barr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        // Collect words that appear only once
        List<String> al = new ArrayList<>();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                al.add(e.getKey());
            }
        }

        // Convert the list to an array and return
        return al.toArray(new String[0]);
    }
}