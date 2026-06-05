class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answers = new ArrayList<>();
        String sorted = null;
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs) {
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            sorted = new String(sArray);
            
            if(!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(s);
        }

        for(String s : map.keySet()) {
            answers.add(map.get(s));
        }
        
        return answers;
    }
}
