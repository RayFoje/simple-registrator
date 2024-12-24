import java.util.Scanner;
import java.util.*;
import java.util.stream.IntStream;

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of users: ");
        int numberUser = scanner.nextInt();
        scanner.nextLine();

        List<User> users = new ArrayList<>();

        IntStream.range(0, numberUser).forEach(i -> {
            if (users.size() >= numberUser) {
                System.out.println("You have reached your user limit.");
                printUserList(users);
                System.exit(0);
            }

            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            users.add(new User(name, age));

            System.out.print("Do you want to continue? (y - Yes, n - No): ");
            char selectedExit = scanner.nextLine().charAt(0);

            if (selectedExit == 'y') {
                System.out.print("Calculate average age(1), Print only all names(2), Finish and print result user list(3): ");
                int selectedOption = scanner.nextInt();
                switch (selectedOption) {
                    case 1:
                        System.out.print("Average age:");
                        double averageAge = users.stream().mapToInt(User::getAge).average().orElse(0);
                        System.out.println(averageAge);
                        scanner.nextLine();
                        break;
                    case 2:
                        System.out.println("All name: ");
                        users.stream().map(User::getName).forEach(System.out::println);
                        scanner.nextLine();
                        break;
                    case 3:
                        printUserList(users);
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Error! Invalid input, please try again!");
                        break;
                }
            } else if (selectedExit == 'n') {
                printUserList(users);
                System.out.println("Exit...");
                System.exit(0);
            } else {
                System.out.println("Error! Invalid input, please try again!");
            }
        });

        System.out.println("You have reached your user limit.");
        printUserList(users);
        System.exit(0);
            }

    private static void printUserList(List<User> users) {
        IntStream.range(0, users.size())
                .forEach(i -> System.out.println("User" + (i + 1) + ": " + users.get(i)));
    }
}

