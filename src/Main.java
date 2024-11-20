import java.util.Scanner;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of users: ");
        int numberUser = scanner.nextInt();
        scanner.nextLine();
        List<String> userNames = new ArrayList<>();
        List<Integer> userAges = new ArrayList<>();

        IntStream.range(0, numberUser).forEach(i -> {
            if (userNames.size() >= numberUser) {
                System.out.println("You have reached your user limit.");
                printUserList(userNames, userAges);
                System.exit(0);
            }

            System.out.print("Enter name: ");
            userNames.add(scanner.nextLine());
            System.out.print("Enter age: ");
            userAges.add(scanner.nextInt());
            scanner.nextLine();
            System.out.print("Do you want to continue? (y - Yes, n - No): ");
            char selectedExit = scanner.nextLine().charAt(0);

            if (selectedExit == 'y') {
                System.out.print("Calculate average age(1), Print only all names(2), Finish and print result user list(3): ");
                int selectedOption = scanner.nextInt();
                switch (selectedOption) {
                    case 1:
                        System.out.print("Average age:");
                        double averageAge = userAges.stream().mapToInt(Integer::intValue).average().orElse(0);
                        System.out.println(averageAge);
                        scanner.nextLine();
                        break;
                    case 2:
                        System.out.println("All name: ");
                        userNames.forEach(System.out::println);
                        scanner.nextLine();
                        break;
                    case 3:
                        IntStream.range(0, userNames.size())
                                .forEach(j -> System.out.println("User" + (j + 1) + ": " + userNames.get(j) + ", " + userAges.get(j)));
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Error! Invalid input, please try again!");
                        break;
                }
            } else if (selectedExit == 'n') {
                printUserList(userNames, userAges);
                System.out.println("Exit...");
                System.exit(0);
            } else {
                System.out.println("Error! Invalid input, please try again!");
            }
        });

        System.out.println("You have reached your user limit.");
        printUserList(userNames, userAges);
        System.exit(0);
            }

    private static void printUserList(List<String> userNames, List<Integer> userAges) {
        IntStream.range(0, userNames.size())
                .forEach(i -> System.out.println("User" + (i + 1) + ": " + userNames.get(i) + ", " + userAges.get(i)));
    }
}

