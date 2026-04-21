class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count =0;
        int sum =0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<n;i++){
            sum = sum + nums[i];
            int val = sum - k;
            if(map.containsKey(val)){
                count = count + map.get(val);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}