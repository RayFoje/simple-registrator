import java.util.Scanner;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of users (1-150): ");
        int numberUser = readValidInt(scanner, 1, 150);

        List<User> users = new ArrayList<>();

        IntStream.range(0, numberUser).forEach(i -> {
            System.out.println("User " + (i + 1) + ":");
            String name;
            while (true) {
                System.out.print("Enter name: ");
                name = scanner.nextLine();
                if (isValidName(name)) {
                    break;
                } else {
                    System.out.print("Error! Name must only contain letters and cannot be empty. Try again. ");
                }
            }

                System.out.print("Enter age: ");
                int age = readValidInt(scanner, 0, 150);

                users.add(new User(name, age));
            });

        while (true) {
            processUserOptions(scanner, users);
        }
    }

    private static void printUserList(List<User> users) {
        int i = 0;
        users.stream()
                .forEach(user -> System.out.println("User" + (i + 1) + ": " + user));
    }

    private static boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty() && name.matches("[a-zA-Zа-яА-Я\\s]+");
    }

    private static int readValidInt(Scanner scanner, int min, int max) {
        while (true) {
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.printf("Error! Enter a number between %d and %d. Try again:", min, max);
                }
            } else {
                System.out.print("Error! Invalid input. Please enter an integer:");
                scanner.nextLine();
            }
        }
    }

    private static void processUserOptions(Scanner scanner, List<User> users) {
        System.out.print("\nSelect option: \n1 - Calculate average age \n2 - Print only all names \n3 - Finish and print result user list \nYour choice: ");
        int selectedOption = readValidInt(scanner, 1, 3);
        switch (selectedOption) {
            case 1:
                System.out.print("Average age:");
                double averageAge = users.stream().mapToInt(User::getAge).average().orElse(0);
                System.out.println(averageAge);
                break;
            case 2:
                System.out.println("All name: ");
                users.stream().map(User::getName).forEach(System.out::println);
                break;
            case 3:
                printUserList(users);
                System.exit(0);
                break;
        }
    }
}