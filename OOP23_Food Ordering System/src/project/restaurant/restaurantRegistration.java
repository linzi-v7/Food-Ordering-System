package restaurant;

import java.util.Scanner;

public class restaurantRegistration {
    private static final String USER_FILE = "restaurants.txt";

    public static boolean registerRestaurant() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter restaurant name: ");
            String restaurant = scanner.nextLine();
            System.out.print("do you want to change the restaurant name ");
            String decision = scanner.nextLine().toLowerCase();

            if (!decision.equals("yes")) break;
        }
//enters the name of the restaurant and checks if he wants to enter the name again
        while (true) {

            String RestaurantNum;
            boolean repeat = true;
            while (repeat) {
                System.out.println("enter phone number:");
                while (!scanner.hasNextInt()) {
                    scanner.next();
                    // Clear the buffer


                    System.out.println("Error: Please enter a valid phone number.");

                }
                //checks that the phone number is nothing else but numbers
                String number = scanner.next();
                int compareNumber = number.length();
                if (compareNumber == 11) {
                    repeat = false;
                } else
                    System.out.println("please enter the full number");


            }
            //checks length of the number
            System.out.print("do you want to change the phone number?");
            String decision = scanner.next().toLowerCase();

            if (!decision.equals("yes")) break;
        }
//enters the number of the restaurant and checks if he wants to enter it again


//         checks the length of the phone number
//            checks if input is a number
        while (true) {
            System.out.print("Enter restaurant address ");
            String restaurantAddress = scanner.next();
            System.out.print("do you want to change the restaurant address ?");
            String decision = scanner.next().toLowerCase();

            if (!decision.equals("yes")) break;
        }
//enters the address of the restaurant and checks if he wants to enter it again
        while (true) {
            System.out.print("Enter restaurant Email ");
            String restaurantEmail = scanner.next();
            System.out.print("do you want to change the Email ");
            String decision = scanner.next().toLowerCase();

            if (!decision.equals("yes")) break;
        }
        return false;
    }
//enters the email of the restaurant and checks if he wants to enter it again
}