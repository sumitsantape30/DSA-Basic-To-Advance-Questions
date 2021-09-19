public static Node linearize2(Node node) { //yeh linear karne ke sath sath tail bhi return karte hai
		if( node.children.size() == 0) { //basecase
			return node; //size 0 hai to node kohi return karde
		}
		
		Node lkt= linearize2(node.children.get(node.children.size()-1)) ;// lkt : last ki tail. linearize2 call karke usme last node pass karenge
		// so muje last ki tail mil gyi aur last wala linear bhi hogya
		
		while( node.children.size() > 1) { //jabtak node ke children ka size 1 se bda hai
			Node last= node.children.remove(node.children.size() - 1); //aakhri wale ko remove karenge so ab last variable ke andar woh pda hai
			
			// ab jo new last hai jo actually mai 2nd last hai to uski tail mangayenge
			Node sl= node.children.get(node.children.size()-1); //yeh pehle seocnd last tha but last wale ko remove kardiya to ab yahi last hai siliye -1 kiye
			Node slkt=  linearize2(sl); //second last ki tail
			// so yeh linear bhi hogya aur usne muje anpi tail bhi dedi
			
			//so ab muje second last ke children mai add karna hai last ko
			slkt.children.add(last);
		}
		
		//so yeh sab ke bad jo tail humare pas aayi hai woh last ki tail return karenge
		return lkt; 
	}

