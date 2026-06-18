class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String string : strs){
            char[] arr = string.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(string);
        }
        return new ArrayList<>(map.values());
    }
}
