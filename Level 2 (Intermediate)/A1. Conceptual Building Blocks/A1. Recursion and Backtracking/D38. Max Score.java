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

//==================================================================== JB's==========================================================

import java.io.*;
import java.util.*;

public class Main {

 public static int solution(String[] words, int idx, int[] farr, int[] score) {
		if( idx == words.length){ // index badhte badhte pohoch gya words.length pe  to waha to koi word hi nhi rehta to yaha max score 0 hoga so return 0
		  return 0;
		}

		//pehle no ki call ki iss word ko select nhi kr rhe
		int f1 = 0 + solution(words, idx + 1, farr, score); //f1: factor 1, current word ko include nhi kr rhe, current word ka faisla hogya to next pe chalo. maine bola current word ko include nhi kr rha bakike bache hue words tum apni arrangement ke according btado li max score kitna bana rhe ho current word to nhi aa rha, to hum bache hue words ka max score lake do
		int f2 = 0; // dusra factor hoga jisme mai current word ko include karna chahta hu

		//pehle muje dekhna hoga kya yeh current word ban bhi payega
		boolean flag = true; // starting mai true man liya
		int scoreOfCurrentWord = 0;
		
		//agar yeh word possible hai to hum iss word ko banayenge aur iski frquency bhi reduce karenge
		for( int i = 0 ; i < words[idx].length(); i++){ // words[idx] yeh current word hai to uspe loop chalaya aur bari bari se uske characters ayenge to frquency array mai uss character ki frequency reduce krdeta hu
			char ch = words[idx].charAt(i);
			//ek ek character nikala aur iski frequency reduce karenge
			farr[ch - 'a']--;
			scoreOfCurrentWord += score[ch - 'a']; //
		}

		for( int i=0; i < farr.length; i++){
			if( farr[i] < 0){ // agar frequency array mai frequency negative dikh rhi hai to this word is not possible
				flag = false;
			}
		}

		if(flag == true){ // agar flag yahape true hai means word possible hai to mai ha wali choice ko consider krta
		  //yess
		  f2 = scoreOfCurrentWord + solution(words, idx + 1, farr, score); //current word ka score add kardiya aur bakike bache hue words updated frequency array ke sath aap apna result bta do ki maximum score kitna bna
		}

		//wapas aate hue dubara sari chize karni padegi

		for( int i = 0 ; i < words[idx].length(); i++){ 
			char ch = words[idx].charAt(i);
			farr[ch - 'a']++;
		}

		//ab humare pas factor 1 and 2 aachuka hai now final answer, donoka max ya to word ko include krte hue maximum score ayega yafir  word ko exclude krte hue maximum score ayega 
		return Math.max(f1, f2);

	}

  public static void main(String[] args) {

    Scanner scn = new Scanner(System.in);
    int nofWords = scn.nextInt();
    String[] words = new String[nofWords];
    for (int i = 0 ; i < words.length; i++) { // sare words utha liye
      words[i] = scn.next();
    }
    int nofLetters = scn.nextInt();
    char[] letters = new char[nofLetters];
    for (int i = 0; i < letters.length; i++) { // sare letters utha liye
      letters[i] = scn.next().charAt(0);
    }
    int[] score = new int[26];
    for (int i = 0; i < score.length; i++) { // then score of every character from a to z. score array mai store kara liya
      score[i] = scn.nextInt();
    }
    //edge case
    if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
        || score.length == 0) { 
      System.out.println(0);
      return;
    }
    
    int[] farr = new int[score.length]; //frequency array, konsa alphabet kitni bar diya gya hai
    for (char ch : letters) {
      farr[ch - 'a']++;
    }
    System.out.println(solution(words, 0, farr, score));

  }
}
