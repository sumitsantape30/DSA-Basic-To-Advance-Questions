Max Score

1. You are given a list of words, a list of alphabets(might be repeating) and score of every alphabet 
     from a to z.
2. You have to find the maximum score of any valid set of words formed by using the given 
     alphabets.
3. A word can not be used more than one time.
4. Each alphabet can be used only once. 
5. It is not necessary to use all the given alphabets.

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A number N representing number of words
N space separated strings
A number M representing number of alphabets(might be repeating)
M space separated characters
26 numbers representing score of unique alphabets from a to z.
Output Format
Check the sample ouput and question video.

 Constraints
1 <= N <= 14
1 <= length of word <= 15
1 <= M <= 100
1 <= Value of score <= 10
Sample Input
4
dog cat dad good
9
a b c d d d g o o
1 0 9 5 0 0 3 0 0 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0
Sample Output
23

Code:
 
import java.io.*;
import java.util.*;

public class Main {

  public static int solution(String[] words, int[] farr, int[] score, int idx) { // farr: frequency array hai 25 size ka jisme har character ki frequency de rakhi hai. score 25 size ka array hai usme har character ka score pass kiya gya hai, idx hai jo words ke upar laga hai
    
    if( idx == words.length){
        return 0; // koi word bacha hi nhi hai to return 0
    }

    //humare idxth word ke pas 2 choices hoti hai woh ana chahta hai ya nhi ana chahta, woh set ka hissa banna chahta hai ya nhi banna chahta
    int sno = 0 + solution(words, farr, score, idx + 1); // no ki call. sno: score no. jab current word include nhi hua hai. 0 means current word ko shamil nhi kiya gya isliye 0 score diya, badke words ne jo score diya wahi apka score ban gya

    //agar current word ko include krna hai to woh apko kuch score contribute karega
    int sword = 0; // sword: score of ith index word, hum uss word ko shamil karna chahte hai
    boolean flag = true; // true if yes call can be made, yes call mari ja skti hai to yeh true hai aur yes call nhi mari ja skti to yeh false hai
    //but ho skta hai ki hum usko shamil hi nhi kar paye kyuki may be uss word ke andar aisa character ho jiski frequency achi hi nhi hai
    String word = words[idx];
    for (int i = 0; i < word.length(); i++) { // hum yeh check kr rhe hai ki jis word se mai deal kr rha hu uss word ke character ki frquency humare pas allowed hai ki nhi
      char ch = word.charAt(i);

      if (farr[ch - 'a'] == 0) { // agar iss character ki frequency 0 hai to aap usko use nhi kr skte to false set karna padega
        flag = false; // false krdenge ki itns frequency hi nhi hai iss character ka ki aap iss word ko utha ske
      }

      //ab frquency ko kam kardo ki ekbar usage hogya iss character ka
      farr[ch - 'a']--;
      sword += score[ch - 'a'];// aur score word ko badhado
    }

    //yes call karne keliye flag true hona chahiye
    int syes = 0;
    if (flag) {
      syes =  sword + solution(words, farr, score, idx + 1); // iss word ko shamil karne ke bad bakike log apko kya score denge
    }

    //yeh backtrack hoga, fruquency array hai apke pas to niche utarte hue frquency array mai jo change laya hai woh undo karna hoga
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      farr[ch - 'a']++; // jo frequency apne kam ki thi usko wapas aad karlo
    }
    
    //jo donomese jyada hai woh return karenge
    return Math.max( sno, syes); // word ko shamil karke better score ata hai ya word ko na shamil karke better score ata hai 
  }

  public static void main(String[] args) {

    Scanner scn = new Scanner(System.in);
    int nofWords = scn.nextInt();
    String[] words = new String[nofWords];
    for (int i = 0 ; i < words.length; i++) {
      words[i] = scn.next();
    }
    int nofLetters = scn.nextInt();
    char[] letters = new char[nofLetters];
    for (int i = 0; i < letters.length; i++) {
      letters[i] = scn.next().charAt(0);
    }
    int[] score = new int[26];
    for (int i = 0; i < score.length; i++) {
      score[i] = scn.nextInt();
    }
    if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
        || score.length == 0) {
      System.out.println(0);
      return;
    }
    int[] farr = new int[score.length];
    for (char ch : letters) {
      farr[ch - 'a']++;
    }
    System.out.println(solution(words, farr, score, 0));

  }
}
