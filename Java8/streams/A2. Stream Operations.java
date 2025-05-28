package org.example;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        //operations on stream
        List<Integer> list = Arrays.asList(1, 2, 3, 3, 4, 5, 6, 7, 8);
        List<Integer> filteredList = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList()); //pehle filter kiye elements then hume woh elements list mai chaihye the to usko collect kiya list mai
        System.out.println(filteredList);

        //iss filteredlist ko 2 se divide krte hai
        List<Integer> dividedList= filteredList.stream().map(x -> x/2).collect(Collectors.toList());
        System.out.println(dividedList);

        //you can do any number of operation in a single stream as well
        List<Integer> combinedOperations= list.stream().filter(x -> x % 2 == 0).map(x -> x/ 2).distinct().sorted().collect(Collectors.toList());
        System.out.println(combinedOperations); //distinct is used to get unique elements and sorted to sort the elements

        //to sort in descending order aur muje 3 elements chahiye
        // sorted mai for ascending .sort((a,b) -> (a-b));
        //for descending: sort((a,b) -> (b-a)); comparator using lamba expression
        List<Integer> ascendingList= list.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x/2)
                .distinct()
                .sorted((a,b) -> (b-a))
                .limit(3)
                .skip(1)
                .collect(Collectors.toList());
        System.out.println(ascendingList);
        //limit means apko starting ke kitne elements chahiye
        //skip means startin se kitne elements skip krna chahte hai
        //skip lagane ke bad it will give 2 elements.

        //0 se leke 100 tak number generate krne hai but meerko 1 to 100 chahiye to skip 1
        List<Integer> collect = Stream.iterate(0, x -> x+1)
                .limit(101)
                .skip(1)
                .filter(x -> x % 2 == 0)
                .map(x -> x / 10)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(collect);

        //another way to print
        List<Integer> collectt = Stream.iterate(0, x -> x+1)
                .limit(101)
                .skip(1)
                .filter(x -> x % 2 == 0)
                .map(x -> x / 10)
                .distinct()
                .sorted()
                .peek(x -> System.out.println(x))
                .collect(Collectors.toList());

         //min and max bhi nikal skte hai, max mai it needs comparator
        //by default max is max((a,b) -> (a-b)) :isse jo default order hota hai sorting ka which is ascending order usme sabse last element milega
        //isko maine aisa kiya max((a,b) -> (b-a)) : isse sabse kam wala max means 0 milega
        Integer number=  Stream.iterate(0, x-> x+1).limit(101)
                .map(x -> x/20)
                .distinct()
                .peek(System.out::println) //isse distinct ke bad jo range hogi woh print karega
                .max((a,b) -> a-b)
                .get();
        System.out.println(number);

        //count bhi kr skte hai
        Long count=  Stream.iterate(0, n -> n+1).limit(101)
                .map(x -> x/20)
                .distinct()
                .count();
        System.out.println(count);

        //parallelStream: agar boht badi stream hai to usko chunks mai divide krega aur thread assign hojayega ki yeh chunk iss thread pe kam karega yeh thread iss chunk pe kam karega
        //boht sare elements hai tabhi parallel stream use karenge coz woh jada time leti hai
        List<Integer> list2= Arrays.asList(1,2,3,3,4);
        list.parallelStream();
        

    }
}
