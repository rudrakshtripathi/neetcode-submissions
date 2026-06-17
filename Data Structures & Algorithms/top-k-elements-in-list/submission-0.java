class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqmap = new HashMap<>();

        for (int num : nums){
            freqmap.put(num, freqmap.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (Map.Entry<Integer,Integer> entry : freqmap.entrySet()){
            int num = entry.getKey();
            int freq = entry.getValue();

            if (bucket[freq]==null){
                bucket[freq]= new ArrayList<>();
            }
            bucket[freq].add(num);
        }

        int[] result = new int[k];
        int index = 0 ;

        for (int freq  = bucket.length-1; freq>=0 && index<k;freq--){
            if (bucket[freq] != null){
                    for (int num : bucket[freq]){
                        result[index++] = num;
                        if (index == k ){
                            return result;
                        }
                    }
            }
        }
        return result;

    }
}
