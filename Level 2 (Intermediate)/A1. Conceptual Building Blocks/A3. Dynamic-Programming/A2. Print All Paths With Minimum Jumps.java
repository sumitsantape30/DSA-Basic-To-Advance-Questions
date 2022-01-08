Print All Paths With Minimum Jumps

1. You are given a number N representing number of elements.
2. You are given N space separated numbers (ELE : elements).
3. Your task is to find & print  
    3.1) "MINIMUM JUMPS" need from 0th step to (n-1)th step.
    3.2) all configurations of "MINIMUM JUMPS".
NOTE: Checkout sample question/solution video inorder to have more insight.
Input Format
A number N (representing "NUMBER OF ELEMENTS").
ELE1 ,ELE2 ,ELE3 ,ELE4 .... ELEn (N space separated numbers represnting numbers).
Output Format
1) A number representing "MINIMUM JUMPS" need from 0th step to (n-1)th step.
2) Strings representing configurations of "MINIMUM JUMPS".
Check the sample ouput and question video.

Constraints
1 <= N <= 100
1 <= ELE <= 1000
Sample Input
10
3
3
0
2
1
2
4
2
0
0
Sample Output
4
0 -> 3 -> 5 -> 6 -> 9 .
0 -> 3 -> 5 -> 7 -> 9 .

Code:

//------------------ Error hai dekhlena---------------------

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    //2.
    //path bhi karni hai to ab lagayenge reverse engineering
    public static class Pair{
        //pair mai rakhenge index, fir size ki kitni size ki jumps allowed hai iss index se aur fir wahase kitni jumps lagi thi
        int i; // kis index pe hu
        int s; // iss index se kitne size ki jump allowed hai
        int j; // ur iss index se itni jumps lagi thi
        int psf; // path so far
        
        Pair(int i, int j, int psf){
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }
    
    //1. 
    public static void Solution(int arr[]){
        
        Integer dp[]= new Integer[arr.length]; // capital integer wali array banaynge taki isme null dal sake, null isliye jaruri hai kyuki kahi kahise rasta nhi hoga to null dalenge 
        //choti problem last spot pe hai
        dp[arr.length - 1] = 0;// last spot pe 0 dal diye kyuki last spot se koi jump lagegi nhi already pahuche hue hai, aur kisine puche hota ki destination to dest raste kitne hai to answer ata 1 ki kuch mat karo wahi khade rho buta bhi pucha ja rha hai minimum number of moves it'll be 0
        
        for(int i = arr.length - 2 ; i >= 0; i--){ //last second spot se loop chalayenge
            // kisi i par ho to wahase kahatk ja skte ho? wahape jitni steps allowed hai
            int steps = arr[i]; // itni dur tak aap ja skte ho
            
            int min = Integer.MAX_VALUE; // minimum chahiye isliye max set kr rhe hai
            //steps ka loop
            for(int j = 1; j <= steps && i + j < arr.length; j++){ // i + j board ke bahar na nikle
              //so unn sari locations pr jayenge wahapr jisme minimum value pdi hogi woh istemal karenge
                if(dp[i + j] != null && dp[i + j] < min){ //agar dp of i+j null nhi hai aur woh dp of i+j humare min se chota hai to hume naya min milgya
                  min = dp[i+j];
                }
            }
            
            //ho skta hai aap 3 jagah pr jaye sab pe null pda ho matlab kahisebhi rasta nhi tha to tumhara yahase bhi rasta nhi hoga, so agar min Integer.MAX_VALUE hi reh gya to tumhe kuch nhi krna null hi chodna hai but agar MAX_VALUE ke barabr nhi ho means tum update hue ho to dp of i pe min+1 daldo
            if(min != Integer.MAX_VALUE){
                dp[i] = min + 1; //dp of i pe dalenge jitna min leke aaye hai + 1 
            }
        }
        
        System.out.println(dp[0]); //apne yaha minimum jumps print kardi but apka paths bhi print karni hai
        //3.
        //ab hum banate hai array deque
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0, arr[0], dp[0], 0 + "")); // queue mai add kiya new pair usme index initially 0, wahapr size hai arr[0], wahase dp[0] jumps lagengi aur psf mai initially 0 dal dete hai 
        
        //print ke dry mai dekhe the, jab bhi koi path remove hoti hai to uske purane path mai arrow lagakr naya wala add karna hota hai
        while(queue.size() > 0){ // jabtak queue ka size 0 nhi hota tabtak pair remove hoga
          Pair rem = queue.removeFirst();
          
          if(rem.j == 0){ //aise krte krte jab remove ka jump 0 ajaye, jab 0 wali jump ajaye to apke pas answer pda hai 
            System.out.println(rem.psf + " .");
          }
          
          //ab jo remove hua hai iske childrens add honge
          for( int j = 1; j <= rem.s && rem.i + j < arr.length; j++){ //iski conditions smjhne keliye upar wale inner loop ke conditions dekho
              int ci = rem.i + j; // current index
              
              if( dp[ci] != null && dp[ci] == rem.j - 1){ // iska matlab hai jaha jaha mai gya hu woh null ke equal nhi hona chahiye hai aur humse ek kam jump ka equal hona chahiye, aisa hai to hum isko queue mai add karlenge
                queue.add(new Pair(ci, arr[ci], dp[ci], rem.psf + " -> " + ci)); //pair mai dalenge current index
              }
            }
        }
    }
    
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = scn.nextInt();

        Solution(arr);
        scn.close();
    }
}

//======================================================= JB's and Accepted===============================================================

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    
    //bfs keliye hume path so far rakhna padega 
    public static class Pair{
        int idx;
        String psf;
        
        public Pair(int idx, String psf){
            this.idx = idx;
            this.psf = psf;
        }
    }
    
    //2.
    public static void bfs(int dp[], int arr[]){
        Queue<Pair> q = new ArrayDeque<>();
        //queue mai ek naya pair add kardenge jiska indx hoga 0 aur psf mai add karenge 0
        q.add(new Pair(0, "0"));
        
        while(q.size() != 0 ){ //jabtak que ka size 0 nhi hojata apna kam karenge
          
          //pehla kam remove pair
          Pair rp = q.remove();
          int minJumpsFromCurrIdx = dp[rp.idx]; //remove mara aur puchliya ki yahase minimum jumps from current index, current index se minimum jumps kitne lag rhe hai
          
          //jaisehi destination pe pohoch jate hai to apne raste ko print kardenge aur fir aage chalenge
          if( rp.idx == dp.length-1 ){ //apne jo remove pair kiya uska index dp.length-1 ke equal hai to hume ek jawab mil gya apna 
           System.out.println(rp.psf + " .");
           continue; //agar aap destination pe pohoch gye ho to jawab ko print karke aage badhiye dusra jawab dhunde ki koshish kare
              
          }
          
          //ab que mai add karna hai ki woh value kaha kahase bani thi
          for( int jump = 1; jump <= arr[rp.idx]; jump++){ //1 se leke utne tak ka jump laga skte hai, woh value kaha kahase aaayi woh pta karna hai hum, multiple jagah sebhi aa skti hai woh value
            if(rp.idx + jump < dp.length && dp[rp.idx + jump] == minJumpsFromCurrIdx - 1){ //maine dekha uss point pe kya value minJumpsFromCurrIdx-1 pdi hai? eg, minJumpsFromCurrIdx hai 4 aur yahase max jump 3 allowed tha to agle 3 spot pe mai dekhna chahta hu ki kahape value 3 pdi hai, jaha jaha pe value 3 pdi hai uska pair banake queue mai add krdiya
                q.add(new Pair(rp.idx + jump, rp.psf + " -> " + (rp.idx + jump)));
            }
            
          }
        }
    }
    
    //1. 
    public static void Solution(int arr[]){
        int dp[]= new int[arr.length];
        dp[dp.length-1] = 0;
        
        for( int i= dp.length - 2; i >= 0; i--){
            int min = Integer.MAX_VALUE;
            for( int jump = 1; jump <= arr[i] && i + jump < dp.length; jump++){
                min = Math.min(min, dp[i + jump]);
            }
            if( min != Integer.MAX_VALUE){
                dp[i] = min + 1;
            }else{
                dp[i] = min;
            }
        }
        
       System.out.println(dp[0]); //isse humara adha answer sahi print hua but abhi paths bhi print karni hai so bfs lagao
       
       bfs(dp, arr);//dp ke sath original array bhi bhejdo
       
    }
    
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr[i] = scn.nextInt();

        Solution(arr);
        scn.close();
    }
}
