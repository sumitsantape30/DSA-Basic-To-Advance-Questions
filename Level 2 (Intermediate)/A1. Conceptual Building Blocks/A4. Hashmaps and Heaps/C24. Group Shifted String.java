Group Shifted String

1. You are given an array of strings.
2. You have to group the given strings in such a way that all strings in a group are shifted versions of each other. 
3. Two strings s1 and s2 are shifted if -
   -> Length of both the strings is the same.
   -> The difference between ASCII values of every character of s1 and s2 is constant.

Note -> Every string consists of lower-case English letters only.
Input Format
A number N
str1
str2.. N space-separated strings
Output Format
Every line of output contains space-separated strings which represents a group of shifted strings.

Constraints
1 <= N <= 10^4
1 <= length of a string <= 100
Sample Input
9
acd dfg wyz yab mop bdfh a x moqs
Sample Output
acd dfg mop wyz yab 
a x 
bdfh moqs 

Code:

import java.util.*;

public class Main {
    
    //ek function likhenge jo hume code dega string ka, key dega
    public static String getKey(String str){// string se hume key banake dega
      String key = "";
      
      for( int i = 1; i < str.length(); i++){
          char curr = str.charAt(i); //current character
          char prev = str.charAt(i-1);// previous character
          //inka gap nikalenge
          int diff = curr - prev;
          
          if( diff < 0){ //agar difference negative agya to hum difference mai 26 add karn hai
            diff += 26;
          }
          
          //ab key mai yeh add krlo
          key += diff + "#";
      }
      
      key += "."; // last mai dot add krdena
      
      return key;
    }
    

	public static ArrayList<ArrayList<String>> groupShiftedStrings(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String str: strs){
            String key = getKey(str); //sabse pehle key mangwayenge iski
            if( map.containsKey(key) == false){ //kya yeh key already humare pas hai, agar nhi hai to hume ek arraylist banani hogi
              ArrayList<String> list = new ArrayList<>();
              list.add(str);
              map.put(key, list); //aur map mai put kiya key ke against list ko
            }else{
                //agar map mai already pdi hai to new krne ki jarurat nhi hai iss key ke against jo arraylist pdi hai usko nikal lenge
              ArrayList<String> list = map.get(key);
              list.add(str);//string ko list mai dal diya, 
            }
        }
        
        //aise humara sara map banjayega, ab sari values ko ek arraylist mai bharke return krdenge
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for(ArrayList<String> list : map.values()){
            res.add(list);
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
		ArrayList<ArrayList<String>> shiftedGroup = groupShiftedStrings(arr);
		for (ArrayList<String> lst : shiftedGroup) {
			Collections.sort(lst);
		}
		shiftedGroup.sort(new ListComparator());
		display(shiftedGroup);
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
