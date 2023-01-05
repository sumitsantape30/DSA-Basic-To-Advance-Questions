The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 

Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0

Code:

class MedianFinder {
    PriorityQueue<Integer> left;
	PriorityQueue<Integer> right;

		    public MedianFinder() {
		        left = new PriorityQueue<>(Collections.reverseOrder());
		        right = new PriorityQueue<>();
		    }
		    
		    public void addNum(int num) {
		        if(right.size() > 0 && num > right.peek()){
		            right.add(num);
		        }else{
		            left.add(num);
		        }
		        handleBalance();
		    }

		    private void handleBalance(){
		        if( left.size() - right.size() == 2){
		            right.add(left.remove());
		        }else if( right.size() - left.size() == 2){
		            left.add(right.remove());
		        }
		    }
		    
		    public double findMedian() {
		        if( left.size() > right.size()){
		            return left.peek();
		        }else if(right.size() > left.size()){
		            return right.peek();
		        }else {
		        	double ans = (left.peek()+ right.peek())/2.0;
		        	return ans;
		        }
		        
		    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
