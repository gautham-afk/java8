import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

record Employee(String namee, int agee) {}


public class Java11 {
    public static void main(String[] args) throws IOException {
        String name = " Gautham ";
        System.out.println(name.isBlank());
        String name1 = "";
        System.out.println(name1.isBlank());
        String line = "Gautham\nKumar\nr";
        System.out.println(line.lines().collect(Collectors.toList()));
        System.out.println(name.repeat(4));
        System.out.println(name.stripLeading());
        System.out.println(name.stripTrailing());
        System.out.println(name.strip());
        Files.writeString(Path.of("C:\\Users\\GauthamKumar\\OneDrive - Archimedis Digital\\Desktop\\New folder\\java8\\name.txt"), name);
        System.out.println(Files.readString(Path.of("C:\\Users\\GauthamKumar\\OneDrive - Archimedis Digital\\Desktop\\New folder\\java8\\name.txt")));
        var exa = Pattern.compile("Gautham").asMatchPredicate();
        System.out.println(exa.test("Gautham"));
        System.out.println(exa.test("Gautham Kumar"));
        Object obj = "hello";

        String result = switch (obj) {
            case Integer i -> "Integer: " + i;
            case String s -> "String: " + s;
            default -> "Unknown";
        };

        System.out.println(result);

        Employee emp = new Employee("gautham", 25);

        if (emp instanceof Employee(String namee, int agee)) {
            System.out.println(namee + " " + agee);
        }

        //if (s instanceof Employee(_, int agee)) {
        //    System.out.println(agee);
        //}



    }
}