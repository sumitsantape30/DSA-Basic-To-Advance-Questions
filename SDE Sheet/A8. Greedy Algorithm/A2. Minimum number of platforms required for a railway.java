Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required for the railway station so that no train is kept waiting.
Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other. At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms.


Example 1:

Input: n = 6 
arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
Output: 3
Explanation: 
Minimum 3 platforms are required to 
safely arrive and depart all trains.
  
Code:

//================================ Optimsed - sorting ========================

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        //arrival time and departure time arrays ko sort karenge
        Arrays.sort(arr); 
        Arrays.sort(dep); 
  
        //starting mai 1 train aa chuki hai assume kr rhe so initialise platforms needed to 1
        int plat_needed = 1, result = 1; //initially result is 1
        int i = 1, j = 0; //tow pointers for two pointer approach. i=1 liya coz while dry runing we started at second arrival train that is 1st index. and started from first departure train i.e j=0
  
        while (i < n && j < n) { //we're going to move them till it doesnt crosses the boundary
        
            if (arr[i] <= dep[j]) { //agar ek train pehlehi arrive ho rhi hai pehle train depart hone se pehle to hume ek platform lagega
                //<= jarur de coz agar arrival and departure time same hai to hume ek aur platform chahiye hoga
                plat_needed++; 
                i++; //and we'll move to next arrival train
            } 
  
            else if (arr[i] > dep[j]) { //but agar previous train pehle depart ho chuki hai aur dusri train aayi hai to naye platform ki jarurat nhi hai same platform use kr skte hai
                plat_needed--; 
                j++; 
            } 
            //now we'll check the number of platforms required at present
            if (plat_needed > result) 
                result = plat_needed; 
        } 
        return result;
  
    }
    
}
