Problem Statement: You are given an array of prices where prices[i] is the price of a given stock on an ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

//brute force solution but give tle on leetcode
class Solution {
    public int maxProfit(int[] prices) {
        int maxPro =0;
        for( int i=0; i< prices.length; i++){
            for( int j=i + 1; j< prices.length; j++){
                
                if( prices[j] > prices[i]){
                    maxPro= Math.max(prices[j] - prices[i], maxPro);
                }
            }
        }
        return maxPro;
    }
}

//optimal
class Solution {
    public int maxProfit(int[] prices) {
        
        int maxProf = 0; //represents the maximum profit that can be achieved.
        int minPrice = Integer.MAX_VALUE; //This variable is used to keep track of the minimum price seen so far while iterating through the prices array. It is initialized to Integer.MAX_VALUE, which is the maximum possible value for an integer in Java.
       
        for( int i=0; i< prices.length; i++){
            
            if( prices[i] < minPrice){ //jo minPrice rahegi uspe mai kharidunga
                minPrice = prices[i];
                
            }else if( prices[i] - minPrice > maxProf){ //agar current day ki price mere minimun se jada hai means iss din mai bech skta hu agar woh profit jada dega to
                //so profit jada dega ki nhi check karenge
                maxProf = prices[i] - minPrice;
            } 
        }
        
        return maxProf;
    }
}
