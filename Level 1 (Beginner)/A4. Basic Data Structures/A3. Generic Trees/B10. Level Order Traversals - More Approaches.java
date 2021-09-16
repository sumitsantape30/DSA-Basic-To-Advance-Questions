Approach 2 ============================================================================

Code:

private static class
  
  Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
		
		// main queue mai null nhi dal skte isliye ek constructor banayenge jo data leta hai
		public Node(int data) {
			this.data= data;
		}
		
		public Node() { //default constructor bhi rakhenge
			
		}
	}


 //approach 2
	 public static void levelOrderLinewise2(Node node) {
		 Queue<Node> mq= new LinkedList<>() ; //isme koi child queue nhi hai
			mq.add(node); 
			mq.add(new Node(-1)); //node ke sath sath maine null bhi add kr skte the but woh nhi hoga so null ki jaga aisa new node dalunga jiska data -1 hoga
			// yeh jo new Node(-1) dal rhe ho uske jagah markingNode banakr bhi dal skte ho, Node markingNode= new Node(-1)
						
			while( mq.size() > 0){ 
				node= mq.remove(); 
				//jo remove kiya hai uska data agar woh -1 nhi hai to print kardo aur uska children add kardo
				if( node.data != -1) {
					
				 System.out.println(node.data+" "); 
				 
				 for( Node child: node.children) {
					 mq.add(child);
				 }
			
				}else { // agar node ka data -1 hai to enter lagao aur markingNode ko wapas queue mai daldo
					if( mq.size() > 0) { //agar muje markingNode mila hai but queue ka size 0 hai to usko firse dalne ki jarurat nhi hai, so tabhi dalenge jab queue ki size > 0
						System.out.println();
						mq.add(new Node(-1)); 
					}		
				}	
			}
	 }

Appraoch 3 (Count Approach)===========================================================================================
   //approach 3 -- Count approach
	public static void levelOrderLinewise3(Node node) {
		Queue<Node> mq = new LinkedList<>(); // isme koi child queue nhi hai ek hi queue hai
		mq.add(node);

		while (mq.size() > 0) {
			int cicl= mq.size(); //aatehi yeh dekhe children in current level aur woh main queue ka size aapko batayega
			//jitni current time pe queue ki size rahegi utne removal karna hai
			for( int i=0; i< cicl; i++) { //jitne children hai current level mai utni bar loop chalaye
				//aur fir wahi rpa
				node= mq.remove();
				System.out.println(node.data +" ");
				
				for( Node child: node.children ) {
					//hum wapas usko add kardenge
					mq.add(child);
				}
			}
			
			//ab jab iss loop mese bahar niklenge to current level khatam ho chuka hai to enter mariya
			System.out.println();
		}
	}

Approach 4 (Pair) ===================================================================
  
   static class Pair { //pair class banayenge jisme node and level hogi
		  Node node;
		  int level;
		  
		  public Pair(Node node, int level) {  // constructor
			  this.node= node;
			  this.level= level;
		  }
	 }// yeh pair tayar 
	 
	public static void levelOrderLinewise3(Node node) {
		Queue<Pair> mq = new LinkedList<>(); //isbar humari Queue<Node> ki nhi <Pair> ki hai
		mq.add(new Pair(node, 1));// miane isme new Pair dali aur usme node pass ki aur pehle node ka level hoga 1
		
		int level = 1; //bahar level nam ka variable bna lenge
		while( mq.size() > 0) {
			Pair p= mq.remove();
			// yeh remove hua
			if( p.level > level) { //ab dekhe kya p ka level jo hai kya woh level se bda hai
				//agar level se bda hai to pehle level ko set kardo aur ek enter laga do
				level= p.level;
				System.out.println();
			}
			
			// agr aisa nhi hai woh usi level ka hai to simple print kare
			System.out.println(p.node.data+ " ");
			// aur uske children keliy loop chala de
			for(Node child: p.node.children) {
				Pair cp= new Pair(child, p.level +1); // child pair , aur uska level p.level se ek jada hoga
				mq.add(cp); // aur isko main queue mai add karlo
			}
		}	
	}
  
