public interface Employee {

    String getName();

}


public class Dev implements Employee {

    @Override
    public String getName(){
        return "Sumit";
    }

}

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) {

        Dev dev= new Dev();
        System.out.println(dev.getName());

        //instead of writing above long code i can write in lambda expression
        //function interface(dev) acts as a datatype for lambda expression
        Employee dev2 = () -> "Software Engineer";
        System.out.println(dev2.getName());

    }
}

