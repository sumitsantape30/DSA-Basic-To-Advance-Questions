Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]

Code:

//======================================= Optimised - o(logk)===================
class Solution {

    public static class Pair implements Comparable<Pair>{
        int data;
        int count;

        public Pair(int data, int count){
            this.data = data;
            this.count =  count;
        }

        public int compareTo(Pair o){
            return this.count- o.count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map= new HashMap<>();
        //creating map takes o(n)
        for(int i=0; i< nums.length; i++)map.put(nums[i], map.getOrDefault(nums[i], 0)+1);

        PriorityQueue<Pair> pq= new PriorityQueue<>(Collections.reverseOrder());

        for( int i=0; i< nums.length; i++){
            if( map.containsKey(nums[i])){
                pq.add(new Pair(nums[i], map.get(nums[i])));
                map.remove(nums[i]);
            }
        }

        int ans[]= new int[k];
        int idx=0 ;
        
      //removing k elements from PQ takes O(logk)
        while( k > 0){
            ans[idx]= pq.remove().data;
            idx++;
            k--;
        }
        return ans;
    }
}
