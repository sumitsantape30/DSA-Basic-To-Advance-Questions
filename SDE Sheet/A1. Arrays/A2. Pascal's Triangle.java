class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> row, pre = null; // row is defining our current row, we also difined the list prev which defines the previous row
		 for (int i = 0; i < numRows; ++i) {
             
			row = new ArrayList<Integer>();//everytime we visit a new row we initialise it with empty arraylist
			for (int j = 0; j <= i; ++j) //number of rows is equal to number of columns in pascal
				if (j == 0 || j == i)// we checked if it is the first column or the last column the answer of that place will always be 1
					row.add(1);
				else //and if its not first and last row
					row.add(pre.get(j - 1) + pre.get(j));
			pre = row; //we update the previous so that we can use it in next iteration
			res.add(row); //add this current row in the resultatn
		}
		return res;
    }
}
