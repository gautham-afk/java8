import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

class Students {

    String name;
    private final int marks;
    private final int rollNo;
    List<String> names;

    Students(String name, int marks, int rollNo, List<String> names) {
        this.name = name;
        this.marks = marks;
        this.rollNo = rollNo;
        this.names = names;
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
}

public class Student {

    public static void main(String[] args) {

        List<String> names = Arrays.asList(
                "John",
                "Alice",
                "Bob",
                "David"
        );

        Students s1 = new Students("Gautham", 39, 1, names);

        s1.display();
        s1.isPassed();

        s1.displayNamesWithLambda();

        s1.sortNumbers();
    }
}