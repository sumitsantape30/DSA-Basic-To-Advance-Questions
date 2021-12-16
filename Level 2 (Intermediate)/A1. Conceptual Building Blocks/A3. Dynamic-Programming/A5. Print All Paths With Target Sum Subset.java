Print All Paths With Target Sum Subset

1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number "tar".
4. You are required to calculate and print true or false, if there is a subset the elements of which add up to "tar" or not.
5. Also, you have to print the indices of elements that should be selected to achieve the given target.
6. You have to print all such configurations.
Input Format
A number n
n1
n2
.. n number of elements
A number tar
Output Format
Check the sample output and question video.

Constraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 20
0 <= tar <= 50
Sample Input
5
4
2
7
1
3
10
Sample Output
true
2 4 
1 2 3 
0 1 3 4 

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static class Pair {
    int i;
    int j;
    String psf;

    public Pair(int i, int j, String psf) {
      this.i = i;
      this.j = j;
      this.psf = psf;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    int tar = Integer.parseInt(br.readLine());

    boolean dp[][] = new boolean[arr.length + 1][tar + 1];

    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if ( j == 0) { //first column mai humesha true hoga kyuki 0 runs to harkoi bana deta hai
          dp[i][j] = true;
        } else if ( i == 0) { //agar pehli row hai to false rahega humesha kyuki agar apki team mai batsmen nhi hai
          dp[i][j] = false;
        } else {
          //ab baki spots pe 2 bate ho skti hai apka jo current banda hai woh batting karega ya nhi karega woh include hoga ya exclude hoga, agar woh include hota hai baki team keliye bache hue run kam hojate hai

          if (dp[i - 1][j]) { //agar bachi(i-1) hui team sare(j) runs bana deti hai to true hai. To aap tak ki team bhi obviously utne runs bana hi legi to aap batting mat krna coz piche wali team already utne run score krleti hai
            dp[i][j] = true;
          } else if ( j >= arr[i - 1]) { // agar team sare runs nhi bana pati to hum dekhenge kya woh runs mai score krpaunga agar woh score mere run se jada honge tabhi woh runs ka kuch part score kr skta hu. aur array mere koi value use krte waqt i-1 likhna padega
            //so agar j aap jitne runs banate ho usse jada hai to apke pas options hai ki app batting kr skte ho
            if (dp[i - 1][j - arr[i - 1]] == true) { //agar bachi hui team(i-1) bache hue runs(j - arr[i-1]) bana leti hai to true dal denge
              dp[i][j] = true;
            }
          }
        }
      }
    }

    System.out.println(dp[arr.length][tar]);

    //ab reverse engineering start karenge
    ArrayDeque<Pair> queue = new ArrayDeque<>();
    queue.add(new Pair(n, tar, "")); //isme last wale ko add krdo, yaha i=n, j= tar, aur psf initially "".

    while ( queue.size() > 0) { //jabtak queue empty nhi hojati hum kam krte rahenge
      //jisko humne queue mai dal usko nikalenge aur iske 2 spots hai jab yeh include nhi hota hai aur jab yeh include hota hai unn donomese jaha jaha true pda hai usko dal do aise aise aage chalte rahenge 0,0 pe jo pohchega uski path ko print kardenge

      Pair rem = queue.removeFirst(); //pair ko remove kiya

      if (rem.i == 0 || rem.j == 0) { //agar 0th row or column mai hai to print krde
        System.out.println(rem.psf);
        
      } else { //pehle include wale ko lenge fir exclude wale ko

        if ( rem.j >= arr[rem.i - 1]) { //include mai check karenge pehle kya score itna bda hai ki yeh banda batting kr ske to yeh include ki bat ati hai
          boolean inc = dp[rem.i - 1][rem.j - arr[rem.i - 1]]; // yeh included hai, to team bhi choti hui aur runs bhi kam hue. (inclue hue the to pichle row mai bhi gye aur score bhi kam hogya)

          if (inc) { //agarr include mai true mila to queue mai add krte hue inclusion dikhayenge
            queue.add(new Pair(rem.i - 1, rem.j - arr[rem.i - 1], (rem.i - 1) + " " + rem.psf )); // team choti hue aur team ke sath run bhi kam honge. aur yeh include hua hai to psf mai iski value include honi chahiye actually indexes dalenge psf mai.

          }
        }

        boolean exc = dp[rem.i - 1][rem.j]; // exclude keliye yeh wala cell dekhna padega. exclude matlab run banaye hi nhi(rem.j) aur team kam hogyi(rem.i-j)
        if (exc) { //agar exclude true hai to queue mai exclude wala child dalde
          queue.add(new Pair(rem.i - 1, rem.j, rem.psf)); //banda exclude hua hai to psf wahi rahega
        }
      }
    }
  }
}
