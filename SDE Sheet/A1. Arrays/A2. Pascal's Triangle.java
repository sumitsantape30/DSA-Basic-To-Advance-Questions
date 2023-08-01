Example 1:

Input Format: N = 5

Result:
    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1

Explanation: There are 5 rows in the output matrix. Each row corresponds to each one of the rows in the image shown above.
Example 2:

Input Format: N = 1

Result: 
    1

Code: 

class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> curr, pre = null; // curr is defining our current row, we also difined the list prev which defines the previous row
		 for (int i = 0; i < numRows; ++i) {
             
			curr = new ArrayList<Integer>();//everytime we visit a new row we initialise it with empty arraylist
			for (int j = 0; j <= i; ++j) //number of rows is equal to number of columns in pascal
				if (j == 0 || j == i)// we checked if it is the first column or the last column the answer of that place will always be 1
					curr.add(1);
				else //and if its not first and last row
					curr.add(pre.get(j - 1) + pre.get(j));
			pre = curr; //we update the previous so that we can use it in next iteration
			res.add(curr); //add this current row in the resultatn
		}
		return res;
    }
}

//=========================Leetcode Submitted ====================================================
class Solution {
    public List<List<Integer>> generate(int numRows) {
        
       List<List<Integer>> res=  new ArrayList<List<Integer>>();
		List<Integer> curr, prev = null;
		
		for( int i=0; i< numRows; i++) {
			
			curr = new ArrayList<Integer>();
			
			for( int j=0; j<= i; j++) {
				
				if( j == 0 || j == i) {
					curr.add(1);
				}else {
					curr.add(prev.get(j-1) + prev.get(j));
				}
			}
			res.add(curr);
			prev = curr;
		}
		return res;
    }
}


Variation 1: In this case, we are given the row number r and the column number c, and we need to find out the element at position (r,c). 

In this case, we are given the row number r and the column number c, and we need to find out the element at position (r,c). 

Code:

import java.util.*;

public class tUf {
    public static long nCr(int n, int r) {
        long res = 1;

        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    public static int pascalTriangle(int r, int c) {
        int element = (int) nCr(r - 1, c - 1);
        return element;
    }

    public static void main(String[] args) {
        int r = 5; // row number
        int c = 3; // col number
        int element = pascalTriangle(r, c);
        System.out.println("The element at position (r,c) is: " + element);
    }
}  
        
