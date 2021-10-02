public static class bstpair {
  
  int min;
  int max;
  boolean isBST;
  Node lbstroot; // largest bst root
  int lbstsize;  // lasgest bst size

}

public static bstpair isBST(Node node) {

  if (node == null) { //agar node null hai to bst pair banayenge
    bstpair bp = new bstpair();
    bp.isBST = true;
    bp.min = Integer.MAX_VALUE;
    bp.max = Integer.MIN_VALUE;
    bp.lbstroot = null; // yeh BST root aur size set nhi kiya tabhi woh by default set hojayega
    bp.lbstsize = 0;
    return bp;
  }

  bstpair lp = isBST(node.left); //maine left ko bola tu apna answer dede
  bstpair rp = isBST(node.right); // right ko bola tu apna answer dede

  bstpair mp = new bstpair();// ab mai apna answer banaunga

  //my pair ka min max set karenge
  mp.min = Math.min(node.data, Math.min(lp.min, rp.min));
  mp.max = Math.max(node.data, Math.max(lp.max, rp.max));
  mp.isBST = lp.isBST && rp.isBST && (node.data >= lp.max && node.data <= rp.min);

  if (mp.isBST) {  // agar mypair ka bst agar true hai to largest bstroot yahi node hoga
    mp.lbstroot = node; 
    mp.lbstsize = lp.lbstsize + rp.lbstsize + 1; // largest BST ka size hoga, left and right pe bst rhe honge
  } else if (lp.lbstsize > rp.lbstsize) {  // agar isBST false hai aur left ka largest bst ka size jada hai right ke largest bst ke size se to my pair ka largest bst root wahi hoga jo left wale ne jawab diya hai
    mp.lbstroot = lp.lbstroot;
    mp.lbstsize = lp.lbstsize;
  } else {  
    mp.lbstroot = rp.lbstroot;
    mp.lbstsize = rp.lbstsize;
  } //agar hum khud BST nhi ban paye to left aur right ka size compare karliye ki donoke bst mese kiska size jada hai 

  return mp;
}
