Problem Statement: The weight of N items and their corresponding values are given. We have to put these items in a knapsack of weight W such that the total value obtained is maximized.

Note: We can either take the item as a whole or break it into smaller units.

Example:

Input: N = 3, W = 50, values[] = {100,60,120}, weight[] = {20,10,30}.

Output: 240.00

Explanation: The first and second items  are taken as a whole  while only 20 units of the third item is taken. Total value = 100 + 60 + 80 = 240.00

Code:

import java.util.*;
class Item {
  int value, weight;
  Item(int x, int y) {
    this.value = x;
    this.weight = y;
  }
}

class itemComparator implements Comparator<Item>
{
    @Override
    public int compare(Item a, Item b) 
    {    //comparator will find the value per weight for both the items
        double r1 = (double)(a.value) / (double)(a.weight); 
        double r2 = (double)(b.value) / (double)(b.weight); 
        
        //then we sort them in descending order
        if(r1 < r2) return 1; 
        else if(r1 > r2) return -1; 
        else return 0; 
    }
}
public class solve{
    static double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, new itemComparator()); //sorting the value in descending order, using comparator
        
        int curWeight = 0; 
        double finalvalue = 0.0; //double datatype lenge
        
        //i'll start picking up values
        for (int i = 0; i < n; i++) {
       
            if (curWeight + arr[i].weight <= W) {//if whatever I'm currently carrying(curWeight) and I add the current item, if that is less than the capacity of sack 
                curWeight += arr[i].weight;//I simply pick up the current item and add it to a currentweight, this current item can be considered
                finalvalue += arr[i].value; //and I add that value to my answer
            }
             else { //but if that is exceeding the knapsack so I'm gonna pickup a fraction of it
                int remain = W - curWeight;//i'll figure out the remaining capacity. capacity - current weight
                finalvalue += ((double)arr[i].value / (double)arr[i].weight) * (double)remain;//now if find the value per weight of the current item
                break;//then i'll break because I know knapsach is filled
            }
        }
     
        return finalvalue;
        
    }
    public static void main(String args[])
    {
        int n = 3, weight = 50;
        Item arr[] = {new Item (100,20),new Item(60,10),new Item(120,30)};
        double ans = fractionalKnapsack(weight, arr, n);
        System.out.println("The maximum value is "+ans);
    }
}
