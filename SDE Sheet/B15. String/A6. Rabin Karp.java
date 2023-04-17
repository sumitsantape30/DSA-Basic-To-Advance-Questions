Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it. If it is impossible for b​​​​​​ to be a substring of a after repeating it, return -1.

Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".

 
Example 1:

Input: a = "abcd", b = "cdabcdab"
Output: 3
Explanation: We return 3 because by repeating a three times "abcdabcdabcd", b is a substring of it.
Example 2:

Input: a = "a", b = "aa"
Output: 2

Constraints:

1 <= a.length, b.length <= 104
a and b consist of lowercase English letters.

Code:

class Solution {
    int mod = 1000000000;
    public int repeatedStringMatch(String a, String b) {
        if(a.equals(b)) return 1;
        int count = 1;
        StringBuilder s = new StringBuilder(a);
        while(s.length() < b.length()){
            count++;
            s.append(a);
        }
        if(robinKarp(s.toString(), b)) return count;
        if(robinKarp(s.append(a).toString(), b)) return ++count;
        return -1;
    }
    
    public boolean robinKarp(String main, String target){
        int hash_t = hashValueCalculator(target); //pehle target ki hash value nikal rhe hai
        int t_len = target.length(); //target ki length
        int hash_m = 0; //main string ki hash value initially 0
        for(int i=0; i<main.length(); i++){
          
            if(i<t_len-1) { //i agar target ke length se kam hi hai to bas aage badhte rho
                continue;
            } else if(i == t_len-1){ //jaisehi i ki length target string ke length ke barbr hogyi means hum iss current substring ko check kr skte hai
                hash_m = hashValueCalculator(main.substring(0, t_len)); //main string mai jo yeh substring hai uski hash value manga rhe
                if(hash_m == hash_t){ //agar iss substring ki hashvalue aur target string ki hashvalue same hai to yeh helper method ko call karege to check for every character 
                    return robinKarpHelper(main, target, 0 , t_len);
                }
            } else { //aur agar index target ki length se bada hai
             // it updates the hash value of the main string by subtracting the ASCII value of the character that is removed and adding the ASCII value of the new character. 
                hash_m = (int)((hash_m - ((main.charAt(i-t_len)-'`')*Math.pow(10, t_len-1)))*10+(main.charAt(i)-'`'))%mod;
                if(hash_m == hash_t){ //Then it compares the updated hash_m with the hash_t. If they are equal it calls the robinKarpHelper method to check for an exact match between the substring of the main string and the target string.
                    return robinKarpHelper(main, target, i-t_len+1, t_len);
                }
            }
        }
        return false;
    }
    
  //this method checks for every character of substring of main string starting at start index and target. koi mismatch rha to false return karega
    public boolean robinKarpHelper(String main, String target, int start, int len){
        int i = start;
        int end = start + len - 1
        int index = 0;
        while(i<end){
            if(index<len && i<main.length() && main.charAt(i) != target.charAt(index))
                return false;
            i++;
            index++;
        }
        return true;
    }
    
  
    public int hashValueCalculator(String s){
        int hashValue = 0, i=0;
        while(i<s.length()){
            hashValue += ((s.charAt(i)-'`')*Math.pow(10, s.length()-i-1))%mod;
            i++;
        }
        return hashValue;
    }
}

//=========================================== Chatgpt ==============================================

public static int repeatedStringMatch(String a, String b) {
    // Calculate the hash value of the pattern
    int bHash = b.hashCode();

    int aLen = a.length(), bLen = b.length();
    int maxRepeats = (bLen / aLen) + 2; // Maximum number of times a can be repeated to obtain b
    int aHash = a.hashCode();

    // Repeat a and compare the hash values until the hash values match or the maximum number of repeats is reached
    for (int i = 1; i <= maxRepeats; i++) {
        if (aHash == bHash && b.startsWith(a)) {
            return i;
        }
        aHash = (aHash * 31 + a.hashCode()) % 1000000007; // Using a prime number to avoid hash collisions
        a += a;
    }

    return -1;
}


