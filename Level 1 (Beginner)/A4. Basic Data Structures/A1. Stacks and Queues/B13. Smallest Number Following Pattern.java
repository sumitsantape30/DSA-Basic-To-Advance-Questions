Smallest Number Following Pattern

1. You are given a pattern of upto 8 length containing characters 'i' and 'd'.
2. 'd' stands for decreasing and 'i' stands for increasing
3. You have to print the smallest number, using the digits 1 to 9 only without repetition, such that 
the digit decreases following a d and increases follwing an i.

e.g.
d -> 21
i -> 12
ddd -> 4321
iii -> 1234
dddiddd -> 43218765
iiddd -> 126543
Input Format
Input is managed for you
Output Format
Smallest sequence of digits (from 1 to 9) without duplicacy and following the pattern


Constraints
0 < str.length <= 8
str contains only 'd' and 'i'
Sample Input
ddddiiii
Sample Output
543216789

Code:

 private static void smallestNumber(String str) {
		Stack<Integer> st = new Stack<>();
		int num = 1;
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			
			if ( ch == 'd' ) {
				st.push(num);
				num++;
			}else {
				st.push(num);
				num++;
				
				while(!st.isEmpty()) {
					System.out.print(st.pop());
				}
			}
		}
		st.push(num);
		while(!st.isEmpty()) {
			System.out.print(st.pop());
		}
		
	}
