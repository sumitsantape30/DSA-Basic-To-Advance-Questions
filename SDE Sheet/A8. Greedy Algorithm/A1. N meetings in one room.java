There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i]) where start[i] is start time of meeting i and end[i] is finish time of meeting i.
What is the maximum number of meetings that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time?

Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.


Example 1:

Input:
N = 6
start[] = {1,3,0,5,8,5}
end[] =  {2,4,6,7,9,9}
Output: 
4
Explanation:
Maximum four meetings can be held with
given start and end timings.
The meetings are - (1, 2),(3, 4), (5,7) and (8,9)
Example 2:

Input:
N = 3
start[] = {10, 12, 20}
end[] = {20, 25, 30}
Output: 
1
Explanation:
Only one meetings can be held
with given start and end timings.
  
Code:

static class Pair implements Comparable<Pair> {
        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Pair o) {
            return this.end - o.end;
        }
    }

    public static int maxMeetings(int[] start, int[] end, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(new Pair(start[i], end[i]));
        }

        int c = 1;
        int ed = pq.poll().end;

        while (!pq.isEmpty()) {

            Pair p = pq.poll();
            if (p.start > ed) {
                c++;
                ed = p.end;
            }
        }
        return c;
    }

//====================================================== TUF ============================================================

import java.util.*;
class meeting {
    int start;
    int end;
    int pos;
     
    meeting(int start, int end, int pos)
    {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}
class meetingComparator implements Comparator<meeting>
{
    @Override
    public int compare(meeting o1, meeting o2) 
    {
        if (o1.end < o2.end)
            return -1;
        else if (o1.end > o2.end)
            return 1;
        else if(o1.pos < o2.pos)//and if finishing time is equal we'll check for position, if meeting number is smaller than the other meeting number
            return -1;
        return 1; 
    }
}
public class Meeting {
    static void maxMeetings(int start[], int end[], int n) {
        ArrayList<meeting> meet = new ArrayList<>();
        
        for(int i = 0; i < start.length; i++) //we're adding the start time, end time and meeting number in the data structure, 1 based indexing
            meet.add(new meeting(start[i], end[i], i+1));
        
        //we create a object of the comparator to be used
        meetingComparator mc = new meetingComparator(); 
        
        Collections.sort(meet, mc); //we'll sort the meet data structure using the comparator object mc
        
        ArrayList<Integer> answer = new ArrayList<>();//this arraylist is going to store the meeting order
        answer.add(meet.get(0).pos);//adding th first meeting in our answer
        int limit = meet.get(0).end; // aur first meeting ka end time rakh rhe hai, this will help
        
        for(int i = 1;i<start.length;i++) {//then i'll iterating from first meeting to the last meeting
            if(meet.get(i).start > limit) {//if starting time of current meeting is greater than end time of last meeting I performed then I can perform this meeting
                limit = meet.get(i).end; //current meeting ka end time, updating my limit
                answer.add(meet.get(i).pos);//add current meeting to the answer
            }
        }
        System.out.println("The order in which the meetings will be performed is ");
        for(int i = 0;i<answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }
    public static void main(String args[])
    {
        int n = 6;
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,5,7,9,9};
        maxMeetings(start,end,n);
        
    }
}
