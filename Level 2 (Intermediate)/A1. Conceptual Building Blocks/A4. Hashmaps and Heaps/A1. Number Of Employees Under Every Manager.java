Number Of Employees Under Every Manager

1. You are given number N and 2*N number of strings that contains mapping of the employee and his manager.
2. An employee directly reports to only one manager. 
3. All managers are employees but the reverse is not true.
4. An employee reporting to himself is the CEO of the company.
5. You have to find the number of employees under each manager in the hierarchy not just their direct reports.
Input Format
A number N
N number of lines, where each line contains 2 strings.
Output Format
Name of every employee and number of employees working under him.

Constraints
1 <= N <= 100
Sample Input
6
A C
B C
C F
D E
E F
F F
Sample Output
A 0
B 0
C 2
D 0
E 1
F 5

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static void findComp(HashMap<String, String> map) {

    HashMap<String, HashSet<String>> tree = new HashMap<>() ; // tree ko represent karne keliye yeh data structure bana rha hu, we call it tree, hashmap of string and hashset
    String ceo = ""; //yeh ceo means root hai tree ka

    //jo input mai hashmap mila hai uspe loop lagayenge
    for (String emp : map.keySet()) { //muje sare employees mil jayenge
      String man = map.get(emp); //employee ke samne uske manager ka nam hai hashmap mai

      if ( man.equals(emp)) { //agar manager aur employee equal hai means yeh ceo hai
        ceo = man; //root
      }else{
          //agar equal nhi hai
          if( tree.containsKey(man)){ //kya tree ke andar yeh manager pda hai kya ya nhi pda
          //agar pda hai to uss manager ko current list of employees nikal lo
          HashSet<String> emps = tree.get(man);//managers ke samne wala usko hashset mil gya
             emps.add(emp); //empolyess wale hashset ke andar apna employee add kare
             
          }else{ //agar pehlese nhi pda hai matlab yeh manager pehli bar dek rhe ho aap to new hashSet banaye
            HashSet<String> emps = new HashSet<>();
            emps.add(emp);//hashset mai employe dal de aur manager ke samne dalde employees ki list
            tree.put(man, emps);
          }
      }
      
    }
          //yahatak apka tree ban chuka hai
          //ab traverse karke size nikalenge
          HashMap<String, Integer> result = new HashMap<>();//isme result leke aaunga
          getSize(tree, ceo, result); //maine tree pass kiya, root pass karni thi to ceo pass kiya, aur jisme result leke aaounga woh hashmap
          
          //mera result bharke aaya hoga ab
          for(String emp: result.keySet()){
              System.out.println(emp + " " + result.get(emp));
          }
  }
  
  public static int getSize(HashMap<String, HashSet<String>> tree, String man, HashMap<String, Integer> result){ //manager hai jo hume shuruwat mai ceo pass kiya gya hai, aur woh hashmap hai jisme hume result rakhna hai. Iss result hasmap mai hum dalne wale hai ki F ko kitne bande report krte hai so on
    //jaise generic tree mai size nikalte hai waisehi nikalenge
    
    //basecase, koi aisa manager jo tree mai hai hi nhi
    if(tree.containsKey(man) == false){ 
        result.put(man, 0); //0 dal denge ki nobody report to me
        return 1;
    }
    
    int sz = 0;
    for( String emp: tree.get(man)){ //tree mai manager lagaya, basically muje iske emp(child) pta lag jayenge
      int cs = getSize(tree, emp, result);//maine bolo child ka size mangawao
      sz += cs; //then child ka size size mai add karliya
    }
    
    //ab jab mai iss loop se bahar aya hu to iss manager ko directly indirectly jitne child report krte hai sabke size ka sum aa chuka hai
    result.put(man, sz);
    return sz + 1; //manager ke khudke nam ka 1 add kiya
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    HashMap<String, String> map = new HashMap<String, String>();
    for ( int i = 0; i < n; i++) {
      map.put(scn.next(), scn.next());
    } //hashmap employee ke samne manager dalke de rakha hai
    findComp(map);

  }

}
