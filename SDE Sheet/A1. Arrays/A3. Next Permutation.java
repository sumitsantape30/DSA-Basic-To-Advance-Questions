class Solution {
    public void nextPermutation(int[] A) {
        if(A == null || A.length <= 1) return; // if length of array is null or has single element the next permutation will be he himself
        
        int i = A.length - 2;
        while(i >= 0 && A[i] >= A[i + 1]) i--; 
        if(i >= 0) { // only if we ge the break points, then we again linearly iterate back and we try to find some who is greater than i               
            int j = A.length - 1;              
            while(A[j] <= A[i]) j--;      
            swap(A, i, j);                     
        }//if there's no breakpoint this if would have never performed
        reverse(A, i + 1, A.length - 1);   //after swapping simply reverse the right half   
}

public void swap(int[] A, int i, int j) {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
}

public void reverse(int[] A, int i, int j) {
    while(i < j) swap(A, i++, j--);
}
}
