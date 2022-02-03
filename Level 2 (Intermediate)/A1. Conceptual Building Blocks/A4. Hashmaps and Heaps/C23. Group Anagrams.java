Group Anagrams

1. You are given an array of strings.
2. You have to group anagrams together.

Note -> Every string consists of lower-case English letters only.
Input Format
A number N
str1
str2.. N space-separated strings
Output Format
Every line of output contains space-separated strings which represents a group of anagrams.

Constraints
1 <= N <= 10^4
1 <= length of a string <= 100
Sample Input
5
pepcoding codingpep pepper rapper repepp
Sample Output
codingpep pepcoding 
pepper repepp 
rapper 

Code:

import java.util.*;

public class Main {

	public static ArrayList<ArrayList<String>> groupAnagrams(String[] strs) {
	    
	    HashMap<HashMap<Character, Integer>, ArrayList<String>> bmap = new HashMap<>(); //ek aisa hashmap banaya jisme key hai ek hashmap aur value hai arraylist. keep in mind ki end hashmap dusre hashmap ki key ban skti hai
	    
	    for(String str: strs){ // string nam ke array mese ek string nikali
	      
	      //ab mai yaha frequency map baanaunga
	      HashMap<Character, Integer> fmap = new HashMap<>();
	      
	      for( int i=0; i < str.length(); i++){
	          char ch = str.charAt(i);
	          //character nikala aur frequency map mai put krdi iski frequency
	          fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
	      }
	      
	      //ab mai dekhunga kya jo bigmap hai woh iss frequency map ko key ki tarah contain krta hai ya nhi, agar nhi contain krta hai to yeh pehli bar aa rha hai fir mai ek new arraylist banaunga strings ki
	      if( bmap.containsKey(fmap) == false){
	          ArrayList<String> list = new ArrayList<>();
	          //maine arraylist banai aur iss arraylist mai dalenge uss string ko
	          list.add(str);
	          bmap.put(fmap, list); //bigmap mai put kardenge frequency map ke samne iss list ko jisme ek element dala hai
	      }else{
	          //agar yeh pehlese pda hai to apko arraylist new karne ki jarurat nhi hai yeh pehlese pdi hai to isko nikalenge get krke
	          ArrayList<String> list = bmap.get(fmap); //badewale map mai get lagaunga mai frequency map ke sath aur muje yeh list milegi
	          list.add(str);//iss list ke andar str ko add kardunga
	      }
	    }
	    
	    //to aisa jab krta rahunga to mere pas hashmap mai badewala hashmap tayar hojayega usmese muje bas woh values hi return krni hai
	    ArrayList<ArrayList<String>> res = new ArrayList<>();//arraylists ko ek naye arraylist mai add karke return kardunga
	    for(ArrayList<String> val: bmap.values()){ //jaise keyset ka function hota hai waisehi values kabhi hota hai
	        res.add(val);
	    }
	    
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}
		ArrayList<ArrayList<String>> anagramsGrouped = groupAnagrams(arr);
		for (ArrayList<String> lst : anagramsGrouped) {
			Collections.sort(lst);
		}
		anagramsGrouped.sort(new ListComparator());
		display(anagramsGrouped);
	}

	// it is used to make the result unique
	static class ListComparator implements Comparator<List<String>> {
		@Override
		public int compare(List<String> l1, List<String> l2) {
			if (l1.size() != l2.size()) {
				return l2.size() - l1.size();
			}

			String l1str = l1.get(0);
			String l2str = l2.get(0);
			return l1str.compareTo(l2str);

		}
	}

	public static void display(ArrayList<ArrayList<String>> list) {
		for (int i = 0; i < list.size(); i++) {
			ArrayList<String> currList = list.get(i);
			for (int j = 0; j < currList.size(); j++) {
				System.out.print(currList.get(j) + " ");
			}
			System.out.println();
		}
	}

}
