import java.util.*;

public class Main {

    public static class Student implements Comparable<Student>{
        String name;
        int age;

        public Student(String name, int age){
            this.name= name;
            this.age= age;
        }

        @Override
        public int compareTo(Student o){
            return this.age- o.age;
        }

    }

    public static void main(String[] args) {

        List<Student> list= new ArrayList<Student>();
        list.add(new Student("Sumit", 23));
        list.add(new Student("Santape", 22));
        list.add(new Student("nikhil", 21));

        Collections.sort(list);
        for(Student s: list){
            System.out.println(s.age);
        }

    }
}
