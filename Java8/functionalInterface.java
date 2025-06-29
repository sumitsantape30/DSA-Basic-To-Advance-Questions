public interface ParentInterface {
    default int substract(int a, int b){
        return a-b;
    }
}

public interface Vehicle extends ParentInterface {
    public int add(int a, int b);
}

import java.util.*;

public class Main {

    public static void main(String[] args) {

       Vehicle v1= new Vehicle(){

           @Override
           public int add(int a, int b){
               return a+b;
           }
       };

       Vehicle v2= (a,b) -> a+b;
       System.out.println(v2.add(5,3));

    }
}
