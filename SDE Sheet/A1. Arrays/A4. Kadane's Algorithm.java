Kadane’s Algorithm : Maximum Subarray Sum in an Array
Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
has the largest sum and returns its sum and prints the subarray.

import java.util.*;
class TUF {
  
  //brute force
    public static int maxSubArray(int[] nums, ArrayList < Integer > subarray) {
        int max_sum = Integer.MIN_VALUE;
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        for (int i = 0; i <= n - 1; i++) {
            for (int j = i; j <= n - 1; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++)
                    sum = sum + nums[k];
                if (sum > max_sum) {
                    subarray.clear();
                    max_sum = sum;
                    subarray.add(i);
                    subarray.add(j);
                }
            }
        }
        return max_sum;
    }
  
  //optimised approach
   public static int maxSubArray(int[] nums, ArrayList < Integer > subarray) {
        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int curr_sum = 0;
            for (int j = i; j < nums.length; j++) {
                curr_sum += nums[j];
                if (curr_sum > max_sum) {
                    subarray.clear();
                    max_sum = curr_sum;
                    subarray.add(i);
                    subarray.add(j);
                }
            }
        }
        return max_sum;
    }
  
  //most optimised
   public int maxSubArray(int[] nums) {
        
        int sum= 0;
        int maxi = nums[0];
        for( int i=0 ;i< nums.length; i++){
            sum += nums[i];
            if( sum > maxi){
                maxi = sum;
            }
            if( sum < 0){
                sum = 0;
            }
        }
        return maxi;
    }
  
    public static void main(String args[]) {
        int arr[]={-2,1,-3,4,-1,2,1,-5,4};
        ArrayList < Integer > subarray = new ArrayList < > ();
        int lon = maxSubArray(arr, subarray);
        System.out.println("The longest subarray with maximum sum is " + lon);
        System.out.println("The subarray is ");
        for (int i = subarray.get(0); i <= subarray.get(1); i++) {
            System.out.print(arr[i] + " ");
        }

    }
}

//============most optimised approach

class TUF{
    public static int maxSubArray(int[] nums,ArrayList<Integer> subarray) { 
        int msf=Integer.MIN_VALUE , meh=0 ; 
        int s=0;
        for(int i=0;i<nums.length;i++){ 
            meh+=nums[i]; 
            
            if(meh>msf)
            { 
                subarray.clear();
                msf=meh; 
                subarray.add(s); 
                subarray.add(i); 
            } 
            if(meh<0)
            {
                meh=0; 
                s=i+1;
                
            } 
        } 
 
        return msf; 
    } 
    public static void main(String args[])
    {
        int arr[]={-2,1,-3,4,-1,2,1,-5,4};
        ArrayList<Integer> subarray=new ArrayList<>();
        int lon=maxSubArray(arr,subarray);
        System.out.println("The longest subarray with maximum sum is "+lon);
        System.out.println("The subarray is ");
        for(int i=subarray.get(0);i<=subarray.get(1);i++)
        {
            System.out.print(arr[i]+" ");
        }
        
    }
}

//===================================== my code================================================

package Arrays;

import java.util.Arrays;

public class setMatrixZeroes {
	
	//n^3
	public static void kadane( int arr[]) {
		int maxSum= 0;
		for( int i=0; i< arr.length; i++) {
			
			for( int j= i; j< arr.length; j++) {
				int subsum = 0;
				for( int k= i; k <= j; k++) {
					subsum += arr[k];
					if( subsum > maxSum) {
						maxSum = subsum;
					}
				}
				
			}
		}
		System.out.println(maxSum);
	}

	//n^2
	public static void kadane1( int arr[]) {
		int sum= 0;
		for( int i=0; i < arr.length; i++) {
			int subsum = 0;
			for( int j= i; j< arr.length; j++) {
				 subsum += arr[j];
				 if( subsum > sum) {
					 sum = subsum;
				 }
			}
		}
		System.out.println(sum);
	}
	
	//n
	public static void kadane2( int arr[]) {
		
		int sum= 0;
		int maxi = arr[0];
		
		for( int i=0; i< arr.length; i++) {
			
			sum += arr[i];
			if( sum > maxi) {
				maxi = sum;
			}
			
			if( sum < 0) {
				sum = 0;
			}
			
		}
		System.out.println(maxi);
	}
	

	public static void main(String[] args) {
		int arr[]= {1,3,5,4,2};
		kadane2(arr);
	}

}
