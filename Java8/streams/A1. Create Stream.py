package org.example;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        //create streams for various collections
        List<String> list = Arrays.asList("apple", "Banana", "Cherry");
        Stream<String> myStream = list.stream(); //to convert list into stream

        String array[] = {"apple", "banana", "cherry"};
        Stream<String> stream = Arrays.stream(array); //to convert array to stream

        //can create direct stream: to create value within the range lie 0 to 100 elements
        Stream<Integer> limit=  Stream.iterate(0, n -> n + 1).limit(100); //pehla elements 0 tha and then yeh lambda expression next elements find krne mai help karegi.
        //0 to 100 ki stream bana dega

        Stream<String> limit1= Stream.generate(() -> "hello").limit(5);
        
    }
}
