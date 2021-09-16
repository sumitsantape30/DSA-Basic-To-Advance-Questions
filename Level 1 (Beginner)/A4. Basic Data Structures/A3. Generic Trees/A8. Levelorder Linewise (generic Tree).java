Levelorder Linewise (generic Tree)
1. You are given a partially written GenericTree class.
2. You are required to complete the body of levelorderLineWise function. The function is expected to visit every node in "levelorder fashion" and print them from left to right (level by level). All nodes on same level should be separated by a space. Different levels should be on separate lines. Please check the question video for more details.
3. Input is managed for you.
Input Format
Input is managed for you
Output Format
All nodes from left to right (level by level) all separated by a space.
All levels on separate lines starting from top to bottom.

Constraints
None
Sample Input
24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
Sample Output
10 
20 30 40 
50 60 70 80 90 100 
110 120
  
Code:

public static void levelOrderLinewise(Node node){
		
		Queue<Node> mq= new LinkedList<>() ; // main queue
		mq.add(node); // main queue mai maine add kiya node ko
		
		Queue<Node> cq= new LinkedList<>(); //child queue
		
		while( mq.size() > 0){ // (mq.size() || cq.size()) yeh bhi condition laga skte hai
			node= mq.remove(); //pehle main queue mese removal karenge
			 System.out.println(node.data+" "); //dusra kam printing ka
			 
			 //ab children add honge
			 for( Node child: node.children) {
				 //lekin hum main queue mai add nhi honge woh add honge child queue mai
				 cq.add(child);
			 }
			 
			 //yeh krne ke bad jab aap bahar aaye
			 if( mq.size() == 0) { //agar main queue ka size hai 0 means main queue khali hogyi hai to maltab yeh ek level khatam hota hai
				 mq= cq; //so main queue equal to child queue karde
				 cq= new LinkedList<>();// aur child queue equal to new karde
				 
				 System.out.println(); //ek level khatam hogya hai so enter laga de
			 }
		}
	}
