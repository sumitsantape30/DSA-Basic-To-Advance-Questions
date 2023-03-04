class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> firstOccurence = new HashMap<>(); //yeh store karega prefix sum % k aur woh prefixSumModK first time kab occur hui thi

        int prefixSum =0;

        for( int i=0; i< nums.length; i++){
            prefixSum += nums[i];
            int prefixSumModK = prefixSum % k;

            if(prefixSumModK == 0 && i+1 >= 2)return true; //agar yeh prefectly divide hota hai aur uski length >=2 hai to this is answer

            if(!firstOccurence.containsKey(prefixSumModK)){
                firstOccurence.put(prefixSumModK, i);//agar yeh sum pehli bar arha hai to push prefixsum and its index
            }else{
                    //agar prefix sum already exist krta hai aur uski length>2 hai 
                    if(i - firstOccurence.get(prefixSumModK) >= 2){
                        return true;
                    }
            }
        }
        return false;
    }
}
