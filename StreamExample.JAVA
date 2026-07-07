import java.util.Arrays;
import java.util.List;

public class StreamExample {

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(5, 10, 15, 20, 25);

        System.out.println("Original List");
        System.out.println(nums);

        System.out.println("\nNumbers greater than 10");

        nums.stream()
            .filter(n -> n > 10)
            .forEach(System.out::println);
    }
}