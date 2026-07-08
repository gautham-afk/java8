import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

class Students {

    String name;
    private final int marks;
    private final int rollNo;
    List<Integer> rollnoo;
    List<String> names;

    Students(String name, int marks, int rollNo, List<String> names, List<Integer> rollnoo) {
        this.name = name;
        this.marks = marks;
        this.rollNo = rollNo;
        this.names = names;
        this.rollnoo = rollnoo;
    }

    void display() {
        Function<String,Integer> length = s -> s.length();
        System.out.println(length.apply(name));
        System.out.println("Student: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Roll No: " + rollNo);
    }

    void isPassed() {
        Predicate<Integer> pass = m -> m >= 40;

        if (pass.test(marks))
            System.out.println("Passed");
        else
            System.out.println("Failed");
    }

    void displayNamesWithLambda() {
        names.forEach(System.out::println);
        names.sort(String::compareToIgnoreCase);
        System.out.println(names);
    }

    void sortNumbers() {

        List<Integer> numbers = Arrays.asList(5, 2, 9, 1, 8);

        System.out.println(numbers);

        Collections.sort(numbers);

        System.out.println(numbers);

        numbers.sort((a, b) -> a - b);

        System.out.println(numbers);

        numbers.sort((a, b) -> b - a);

        System.out.println(numbers);
    }

    void streamnamefilter() {
        names.stream()
                .filter(s -> s.startsWith("A"))
                .limit(2)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    void streamnamefilter2() {
        names.stream()
                .sorted()
                .distinct()
                .skip(2)
                .forEach(System.out::println);
    }

    void streamnamefilter3() {
        names.stream()
                .forEach(System.out::println);
    
        names.parallelStream()
                .forEach(System.out::println);
    }

    void  comporqator() {
        names.sort((s1, s2) -> s1.compareTo(s2));
        System.out.println(names);

        
    }

    void compirtordesc(){
        Comparator<String> byNameDesc = (s1, s2) -> s2.compareTo(s1);
        names.sort(byNameDesc);
        System.out.println(names);    
        }

    void comporator_rolno() {

        rollnoo.sort((r1, r2) -> r1.compareTo(r2));
        System.out.println(rollnoo);
    }

    void comporator_rolno_desc() {

    rollnoo.sort(Comparator.reverseOrder());

    System.out.println(rollnoo);
}
}

public class Student {

    public static void main(String[] args) {

        List<String> names = Arrays.asList(
                "John",
                "Alice",
                "Bob",
                "David",
                "Eve",
                "Frank",
                "Grace",
                "Hannah",
                "Ivy"
        );

        List<Integer> rollnoo = Arrays.asList(
                21,
                22,
                23,
                24,
                25,
                26,
                27,
                28,
                29
        );

        Students s1 = new Students("Gautham", 39, 1, names, rollnoo);

        s1.display();
        s1.isPassed();

        s1.displayNamesWithLambda();

        s1.sortNumbers();
        s1.streamnamefilter();
        s1.streamnamefilter2();
        s1.streamnamefilter3();
        s1.comporqator();
        s1.compirtordesc();
        s1.comporator_rolno();
        s1.comporator_rolno_desc();
    }
}