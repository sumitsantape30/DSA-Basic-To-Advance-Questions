Find the Majority Element that occurs more than N/2 times
Problem Statement: Given an array of N integers, write a program to return an element that occurs more than N/2 times in the given array. You may consider that such an element always exists in the array.

Example 1:

Input Format: N = 3, nums[] = {3,2,3}
Result: 3
Explanation: When we just count the occurrences of each number and compare with half of the size of the array, you will get 3 for the above solution. 

Example 2:

Input Format:  N = 7, nums[] = {2,2,1,1,1,2,2}
Result: 2
Explanation: After counting the number of times each element appears and comparing it with half of array size, we get 2 as result.

Code:

class Solution {

    //optimal - TC- n, SC- n
    public static void majorityElement( int arr[]) {
		int n = arr.length;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for( int i=0; i< arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		
		int arraySize = (int)Math.floor(n/2);
		
		for( int i=0; i< arr.length; i++) {
			
			if( map.containsKey(arr[i])) {
				if( map.get(arr[i]) >= arraySize) {
					System.out.println(arr[i]);
					return;
				}
			}
		}
	}

    //most optimal - TC: n, SC: 1
    public int majorityElement(int[] nums) {

	    //In the case of a n/2 majority element, there can be only one element that appears more than n/2 times in the array. 
	    // In other words, the majority element must have a count strictly greater than half of the array size.
	    //hence we take only one variable to collect that one element.
	    
        int count =0; //It keeps track of the current candidate element's count.
        int ele=0; //It keeps track of the current candidate element itself.

        for( int elem: nums){

            if( count == 0){ 
                ele  = elem;
            }

            if(ele == elem){
                count++;
            }else{
                count--;
            }
        }

        return ele;
    }
}
