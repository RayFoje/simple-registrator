import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of users: ");
        int numberUser = scanner.nextInt();
        scanner.nextLine();
        String[] arrayUserName = new String[numberUser];
        int[] arrayUserAge = new int[numberUser];
        int userCount = 0;
        while (userCount < numberUser) {
            System.out.print("Enter name: ");
            arrayUserName[userCount] = scanner.nextLine();
            System.out.print("Enter age: ");
            arrayUserAge[userCount] = scanner.nextInt();
            scanner.nextLine();
            userCount++;
            System.out.print("Do you want to continue? (y - Yes, n - No): ");
            char selelctedExit = scanner.nextLine().charAt(0);
            if (selelctedExit == 'y') {
                System.out.print("Calculate average age(1), Print only all names(2), Finish and print result user list(3): ");
                int selectedOption = scanner.nextInt();
                switch (selectedOption) {
                    case 1:
                        System.out.print("Average age:");
                        int sum = 0;
                        for (int indexUserAge = 0; indexUserAge < userCount; indexUserAge++) {
                            sum += arrayUserAge[indexUserAge];
                        }
                        double averAge = (double) sum / userCount;
                        System.out.println(averAge);
                        scanner.nextLine();
                        break;
                    case 2:
                        System.out.println("All name: ");
                        for (int indexUserName = 0; indexUserName < userCount; indexUserName++) {
                            System.out.println(arrayUserName[indexUserName]);
                        }
                        scanner.nextLine();
                        break;
                    case 3:
                        for (int indexUserName = 0; indexUserName < userCount; indexUserName++) {
                            System.out.println("User" + (indexUserName + 1) + ": " + arrayUserName[indexUserName] + ", " + arrayUserAge[indexUserName]);
                        }
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Error! Invalid input, please try again!");
                        break;
                }
            } else if (selelctedExit == 'n') {
                for (int indexUserName = 0; indexUserName < userCount; indexUserName++) {
                    System.out.println("User" + (indexUserName + 1) + ": " + arrayUserName[indexUserName] + ", " + arrayUserAge[indexUserName]);
                }
                System.out.println("Exit...");
                System.exit(0);
            } else {
                System.out.println("Error! Invalid input, please try again!");
            }
            if (userCount == numberUser) {
                System.out.println("You have reached your user limit.");
                for (int indexUserName = 0; indexUserName < numberUser; indexUserName++) {
                    System.out.println("User" + (indexUserName + 1) + ": " + arrayUserName[indexUserName] + ", " + arrayUserAge[indexUserName]);
                }
                System.exit(0); // Завершаем программу
            }
        }
    }
}