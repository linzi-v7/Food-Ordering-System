package project.restaurant;

import java.util.Scanner;


public class restaurantRegistration {

    /**
     * function to register a new restaurant
     * @param restaurant the object that will be storing the inputs into
     */
    public static void registerRestaurant(Restaurant restaurant) {


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter restaurant name: ");
            restaurant.restaurantName = scanner.nextLine();
            System.out.print("do you want to change the restaurant name? if not enter any key");
            String decision = scanner.nextLine().toLowerCase();

            if (!decision.equals("yes")) break;
        }
//
////enters the name of the restaurant and checks if he wants to enter the name again
        while (true) {


            boolean repeat = true;
            while (repeat) {

                System.out.println("enter phone number:");

                while (!scanner.hasNextInt()) {
                    scanner.next();
                    // Clear the buffer


                    System.out.println("Error: Please enter a valid phone number.");

                }
                //checks that the phone number is nothing else but numbers

                restaurant.restaurantContact = scanner.next();


                int compareNumber = restaurant.restaurantContact.length();
                if ((compareNumber == 11)||(compareNumber==5)) {
                    repeat = false;
                } else

                    System.out.println("please enter the full number");


            }
            //checks length of the number
            System.out.print("do you want to change the phone number? if not enter any key");
            scanner.next();
            String decision = scanner.nextLine().toLowerCase();

            if (!decision.equals("yes")) break;
        }

//enters the number of the restaurant and checks if he wants to enter it again
//         checks the length of the phone number
//            checks if input is a number

        while (true) {

            System.out.println("Enter restaurant address: ");
            restaurant.restaurantAddress = scanner.nextLine();
            System.out.print("do you want to change the restaurant address? if not enter any key");
            String decision = scanner.nextLine().toLowerCase();
            if (!decision.equals("yes")) break;
        }

//enters the address of the restaurant and checks if he wants to enter it again
        boolean validEmail;
        while (true) {
            boolean notUniqueEmail;
            System.out.println("Enter restaurant Email ");
            restaurant.restaurantEmail = scanner.nextLine();
            System.out.println("do you want to change the Email? if not enter any key");
            String decision = scanner.nextLine().toLowerCase();
            validEmail=validateEmail(restaurant.restaurantEmail);
            if(validEmail) {
                notUniqueEmail = restaurant.compareEmail(restaurant.restaurantEmail);
                if (notUniqueEmail) {
                    System.out.println("this Email is already being used please enter an email that was never used here before");
                } else if (!decision.equals("yes")) break;
            }
            else {
                System.out.println("please enter a valid Email");
            }
        }
        //enters the email of the restaurant and checks if he wants to enter it again
        while (true) {

            System.out.print("Enter restaurant password ");
            restaurant.restaurantPassword = scanner.nextLine();
            System.out.print("do you want to change the password? if not enter any key ");
            String decision = scanner.next().toLowerCase();

            if (!decision.equals("yes")) break;

        }

        restaurant.addRestaurantDetails(restaurant.restaurantName, restaurant.restaurantContact, restaurant.restaurantAddress, restaurant.restaurantEmail, restaurant.restaurantPassword);

    }
    static boolean validateEmail(String email)
    {
        // Basic email validation using a regular expression
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(regex);
    }

}
