Given a set of N jobs where each jobi has a deadline and profit associated with it.
Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with job if and only if the job is completed by its deadline.
Find the number of jobs done and the maximum profit.
Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job.

Example 1:

Input:
N = 4
Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
Output:
2 60
Explanation:
Job1 and Job3 can be done with
maximum profit of 60 (20+40).
  
Code:

import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
   int id, profit, deadline;
   Job(int x, int y, int z) {
      this.id = x;
      this.deadline = y;
      this.profit = z;
   }
}

class solve {
   // return an array of size 2 having the 0th element equal to the count
   // and 1st element equal to the maximum profit
   int[] JobScheduling(Job arr[], int n) {
     //sort the array according to decreasing order of profit
      Arrays.sort(arr, (a, b) -> (b.profit - a.profit));//comparator

     //now we'll find the maximum deadline
      int maxi = 0;
      for (int i = 0; i < n; i++) {
         if (arr[i].deadline > maxi) {
            maxi = arr[i].deadline;
         }
      }
      
      int result[] = new int[maxi + 1]; //create an array of size maxi+1. indexes properly mil paye isliye maxi+1

      for (int i = 1; i <= maxi; i++) {
         result[i] = -1;
      }//array mai -1 initialise kridiya

      int countJobs = 0, jobProfit = 0;//count and profit variables

     //iterating for job id
      for (int i = 0; i < n; i++) {
         
        //we take one id and go on from end(last dya) to 1(first day)
         for (int j = arr[i].deadline; j > 0; j--) {

            // Free slot found 
            if (result[j] == -1) {//jo bhi day -1 means empty hai to iss day pe job perfrom karenge
               result[j] = i;//job perform krhe
               countJobs++;
               jobProfit += arr[i].profit;//and add that jobs profit 
               break;//current job hone ke bad break karo hum bas ek hi job perform krna hai, pichese aate hue koi khali din mila to usdin perform kardliya so now break
            }
         }
      }
      
     //output mai array dena hai so 2 size ka array banayenge aur usme count and profit dal denge
      int ans[] = new int[2];
      ans[0] = countJobs;
      ans[1] = jobProfit;
      return ans;

   }
}
class Main {
   public static void main(String[] args) throws IOException {

      //size of array
      Job[] arr = new Job[4];
      arr[0] = new Job(1, 4, 20);
      arr[1] = new Job(2, 1, 10);
      arr[2] = new Job(3, 2, 40);
      arr[3] = new Job(4, 2, 30);

      solve ob = new solve();

      //function call
      int[] res = ob.JobScheduling(arr, 4);
      System.out.println(res[0] + " " + res[1]);

   }
}
