Minimum Number Of Software Developers

1. You are given N strings which represents N different skills related to I.T field.
2. You are working on a project and you want to hire a team of software developers for that project.
3. There are N applicants. Every applicant has mentioned his/her skills in resume.
4. You have to select the minimum number of developers such that for every required skill, there is 
     at least one person in the team who has that skill.
5. It is guaranteed that you can form a team which covers all the required skills.

Note -> Check out the question video for details.
Input Format
A number N representing number of required skills
N space separated strings 
A number M representing number of applicants
For every applicant : A number T representing number of skills of an applicant and then T number of space separated strings.
Output Format
An arraylist containing the indices of selected applicants.
Check the sample ouput and question video.

Constraints
1 <= N <= 16
1 <= length of string <= 16
1 <= M <= 60
Sample Input
3
java nodejs reactjs
3
1
java
1
nodejs
2
nodejs
reactjs
Sample Output
[0, 2]

Code:

import java.io.*;
import java.util.*;

public class Main {

  static ArrayList<Integer> sol = new ArrayList<>(); // yeh sare solutions ka static hai, sare solutions ko compare karayega

  public static void solution(int[] people, int nskills, int cp, ArrayList<Integer> onesol, int smask) { // cp: current person abhi kiska failsa ho rha hai. people: woh jiske andar har person ke skill ke mask hai  smask: skills mask, nskill: number of skills
     
     if( cp == people.length){ // aisa krte krte jab sare log khatam hojayenge to ho skta hai yaha answer ho 
         // but hume sare answers mese wahi consider krne hai jisme sari bits set hai 
         if( smask == (1 << nskills) - 1){ // 1 >> 2 hota hai 100 usmese ek minus krdo
             if( sol.size() == 0 || onesol.size() < sol.size()){ // agar solution ka size 0 ho means abhitak ek bhi mila nhi hai. yafir one solution ka size apse chota hai. so yeh pehle solution or humare pas better solution hai 
                sol = new ArrayList<>(onesol); // solution ko upgrade kardo
             }
         }
         return;
     }
     
     //har bande ke pas means current person ke pas 2 choices hai ki woh aa skta hai or woh nhi bhi aa skta
     //agar humara banda aanese mana krta hai 
     solution(people, nskills, cp+1, onesol, smask); // current person badhega, one solution mai kuch add nhi hoga aur smask bhi waisahi rahega kyuki bande ne NO kaha hai
     
    //agar banda yes kehta hai to pehle one solutin ke andar upar jate jate iss bande ka index add hona chahiye 
    onesol.add(cp);
    
    //aur call lagado
    solution(people, nskills, cp+1, onesol, (smask | people[cp]) ) ; //about last argument: upar jate hue mai pass karunga purana mask(smask) or people of current peroson, skills of current person. jo current person hai uske mask ko purane mask ke sath OR kardiya. current person ke pas jo skills thi woh smask iss mask mai set hogyi 
    
    //aur wapas aate aate onesol mese remove bhi hona chahiye
    onesol.remove(onesol.size()-1);
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    HashMap<String, Integer> smap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      smap.put(scn.next(), i); // yaha input ke andar map banaya hai har skill ke samne uska index, ki 1st skill is for 0, 2nd skill is for 1, 3rd skill is for 2 so on.
    }

    int np = scn.nextInt();
    int[] people = new int[np]; // yaha number of persons ka array banaya
    for (int i = 0; i < np; i++) {
      int personSkills = scn.nextInt();
      for (int j = 0; j < personSkills; j++) { // fir uss person ki skills mai loop lagaya
        String skill = scn.next();
        int snum = smap.get(skill); // skill ka number nikala map mese jo pehle dal diya tha ki yeh skill 0th hai, 'a' aya to 'a' ko 0 mai convert karliya
        people[i] = people[i] | (1 << snum); // aur fir apne andar woh 0th bit on karli, basically yeh people mask bana hua hai
      } // itne kam ne hume mask banake dediye
    }

    solution(people, n, 0, new ArrayList<>(), 0); // so humne people pass kiye hai, total number of skills pass kiye hai , and current person, then ek solution jo hum bana rhe hai, aur skills mai unhone pass kiya hai ki yeh skill woh hai jab aap kisi bande ko unlcude krte ho aur hokar ajati hai basically yeh skills ka mask hai yeh woh chiz hai jispe humne dry run mai yes no lagaya tha
    System.out.println(sol);

  }
}

//===========================================================JB's======================================================

import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<Integer> sol = new ArrayList<>();

	public static void solution(int[] people, int n, int cp, ArrayList<Integer> onesol, int skillsmask) {
        //basecase: jab sare bando ke faila hojaye
        if( cp == people.length){
            //ab muje ismese dekhna kon konse valid case hote hai 
            int skillset = ((1 << n)-1); //yeh hoga apna skillset
            if( skillsmask == skillset){ //to mai bolunga agar skill ka mask barbr hota hai skill set ke to yeh humare liye yeh potential jawab hai, valid candidate hai humare liye
               // valid candidate mai hume minimum nikalna hai 
               if( onesol.size() < sol.size() || sol.size() == 0){ // iss solution ka size agar overall solution ke size se chota hota hai to overall solution ko update krdo. or ho skta haiki solution ke size 0 hi ho to uss case mai bhi update
                   sol = new ArrayList<>(onesol);
               }
            }
            return;
        }

        //2 choices hai banda aayega yafir banda nhi ayega
        //pehli call for nhi ana chahta
        solution(people, n, cp+1, onesol, skillsmask); // people wala array as it is pass hojayega, current bande ka faisla hogya to agle bande ke pas jao, one solution mai kuch add nhi hone wala, skillsmask bhi waisahi rahega

        //ab ha ki call matlab banda ana chahta hai 
        //this is one solution to onesol mai uss bande ko add karo
        onesol.add(cp); //current person ko maine add karliye fir mai lagayi ha ki call
        solution(people, n, cp+1, onesol, (skillsmask | people[cp])); // onesolution arraylist mai jo dalna tha woh dal chuke hai ab skills ka mask badlega, skills ka mask banega abtak ki skills OR current people(bande) ki skill
        //wapas aate hue remove krna hai
        onesol.remove(onesol.size() - 1);

	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashMap<String, Integer> smap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			smap.put(scn.next(), i);
		}
		
		int np = scn.nextInt();
		int[] people = new int[np];
		for (int i = 0; i < np; i++) {
			int personSkills = scn.nextInt();
			for (int j = 0; j < personSkills; j++) {
				String skill = scn.next();
				int snum = smap.get(skill);
				people[i] = people[i] | (1 << snum);
			}
		}

		solution(people, n, 0, new ArrayList<>(), 0);
		System.out.println(sol);
		
	}
}
