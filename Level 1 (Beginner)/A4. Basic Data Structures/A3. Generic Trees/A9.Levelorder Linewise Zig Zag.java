Levelorder Linewise Zig Zag

1. You are given a partially written GenericTree class.
2. You are required to complete the body of levelorderLineWiseZZ function. The function is expected to visit every node in "levelorder fashion" but in a zig-zag manner i.e. 1st level should be visited from left to right, 2nd level should be visited from right to left and so on. All nodes on same level should be separated by a space. Different levels should be on separate lines. Please check the question video for more details.
3. Input is managed for you. 
                               
Input Format
Input is managed for you
Output Format
All nodes on the same level should be separated by a space.
1st level should be visited left to right, 2nd from right to left and so on alternately.
All levels on separate lines starting from top to bottom.


Constraints
None
Sample Input
24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
Sample Output
10 
40 30 20 
50 60 70 80 90 100 
120 110
  
Code:

 public static void levelOrderLinewiseZZ(Node node){

		 //queue ki jagah isbar stacks use kiye
		 Stack<Node> ms= new Stack<>(); //main stack
		 ms.push(node); //main stack mai node ko push kiya
		 
		 Stack<Node> cs= new Stack<>(); // fir humne banayi child stack
		 int level= 1; // shuruwat mai level 1 hai
		 
		 while( ms.size() > 0){
			 node= ms.pop(); //main stack se pop karenge
			 System.out.print(node.data +" ");
			 
			 //ab add children magr depend karega ki level odd wala hai ya nhi
			 if( level % 2 == 0) {
				 //agar level even wala hai to badhta hua loop
				 for( int i=0; i< node.children.size(); i++) {
					 Node child= node.children.get(i);
					 //aur isko child stack mai push karenge
					 cs.push(child);
				 }
			 }else {
				 // agar odd hai
				 for( int i= node.children.size()- 1; i>= 0; i--) {
					 Node child= node.children.get(i);
					 cs.push(child);
				 }
			 }
			 
			 //agar child main stack ka size 0 hogya hai 
			 if( ms.size() == 0) {
				 ms= cs;
				 cs= new Stack<>();
				 //aur level badhaye
				 level++;
				 //aur enter jarur mare
				 System.out.println();
			 }
		 }
 }
