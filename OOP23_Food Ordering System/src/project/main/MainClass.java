package project.main;

import project.cart.cart;
import project.payment.Payment;
import project.restaurant.Restaurant;

import project.restaurant.restaurantRegistration;
import project.admin.Admin;
import project.review.review;
import project.user.User;
import project.user.UserManagementSystem;
import project.menu.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class MainClass {
    public static void main(String[] args) {
        UserManagementSystem.readUserDataFile();
        Scanner scanner = new Scanner(System.in);
        String userEmail = null;
        Restaurant restaurant = new Restaurant();
        restaurant.loadRestaurantsFromFile();

        String isUserCheck;

        do {
            System.out.println("\t####### Food Ordering System #######\n");
            System.out.println("\t\t\t\t Welcome!\n");
            System.out.println("Do you already have an account? Enter Yes or No\n" +
                    "Type exit to close program.");
            isUserCheck = scanner.nextLine();
            System.out.print("\n------------------------------------------------------\n");

            if (isUserCheck.equalsIgnoreCase("yes")
                    || isUserCheck.equalsIgnoreCase("y")) {
                String retry;
                do {
                    retry = "n";
                    if ((userEmail = UserManagementSystem.loginUser(restaurant)).equals("null")) {
                        System.out.println("Would you like to retry?(Y/N)");
                        retry = scanner.nextLine();
                    }
                    //prompts user to retry if they entered wrong credentials
                } while (retry.equalsIgnoreCase("y")
                        || retry.equalsIgnoreCase("yes"));

            } else if (isUserCheck.equalsIgnoreCase("no")
                    || isUserCheck.equalsIgnoreCase("n")) {
                int decision;
                boolean repeat = true;
                while (repeat) {
                    System.out.print("\n------------------------------------------------------\n");
                    System.out.println("to register as  new user enter: 1\n" +
                            "to register as a new restaurant enter 2 ");
                    if (scanner.hasNextLine()) {
                        decision = Integer.parseInt(scanner.nextLine());

                        switch (decision) {
                            case 2:
                                restaurantRegistration.registerRestaurant(restaurant);
                                repeat = false;
                                break;
                            case 1:
                                UserManagementSystem.registerUser(1);
                                repeat = false;
                                break;
                            default:
                                System.out.println("please enter a correct number");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a number from the choices");
                        scanner.nextLine();
                    }
                }
            } else if (isUserCheck.equalsIgnoreCase("exit")) {
                System.exit(0);
            } else {
                System.out.println("Invalid Input");
            }
        } while (Role.getRoleIdentifier() == 0);


        switch (Role.getRoleIdentifier()) {
            case Role.ADMIN_IDENTIFIER:
                adminLaunchProgram();
                break;
            case Role.RESTAURANT_IDENTIFIER:
                restaurantLaunchProgram(userEmail, restaurant);
                break;
            case Role.USER_IDENTIFIER:
                userLaunchProgram(userEmail, restaurant);
        }
    }

    //function to handle program flow after user logs in, should display restaurants, menus,etc..
    public static void userLaunchProgram(String userEmail, Restaurant restaurant) {
        User loggedInUser = UserManagementSystem.getUserByEmail(userEmail);

        //if somehow the user doesn't exist (after multiple checks), we should terminate the program
        if (loggedInUser != null) {
            Scanner scanner = new Scanner(System.in);
            int ChosenRestaurant;
            System.out.print("\n------------------------------------------------------\n");
            System.out.println("\n\t\tWelcome " + loggedInUser.getName() + "!");

            //Display and search restaurant

            System.out.println("select what you want to do and enter the number of the operation that you want.");
            System.out.println("to display all restaurants enter: 1");
            System.out.println("to search for a specific restaurant enter: 2");
            boolean repeat = true;
            while (repeat) {
                if (scanner.hasNextInt()) {
                    int decision = scanner.nextInt();
                    switch (decision) {
                        case 1:
                            int counter = 0;
                            System.out.print("\n------------------------------------------------------\n");
                            for (ArrayList<String> restaurants : restaurant.getRestaurants()) {
                                counter++;
                                System.out.println(counter + "." + restaurants.get(0));
                            }
                            repeat = false;
                            break;
                        case 2:
                            System.out.print("\n------------------------------------------------------\n");
                            restaurant.restaurantSearching(restaurant);
                            repeat = false;
                            break;
                        default:
                            System.out.println("choose a value that exists within the choices");
                    }
                } else {
                    System.out.print("Invalid input. Please enter a number from the choices: ");
                    scanner.next();
                }
            }

            String RestaurantName;
            while (true) {
                try {
                    System.out.print("\n");
                    System.out.print("Enter the number of the restaurant that you want: ");
                    ChosenRestaurant = scanner.nextInt();
                    RestaurantName = restaurant.getRestaurants().get(ChosenRestaurant - 1).get(0);
                    break;
                } catch (IndexOutOfBoundsException exp) {
                    System.out.println("Invalid Input! Try Again!");

                } catch (InputMismatchException exception) {
                    System.out.println("please enter a valid number");
                    scanner.next();
                }
            }
            //display the menu of selected restaurant
            Menu menu = new Menu();
            menu.readMenuDataFile(RestaurantName);

            cart orderCart = new cart();
            System.out.print("\n------------------------------------------------------\n");
            System.out.println("##### " + RestaurantName + "'s Menu #####");
            menu.displayMenu(RestaurantName);

            // User interaction
            System.out.print("\n");
            cart.addToCart(scanner, menu, orderCart);

            // Display the order
            System.out.print("\n------------------------------------------------------\n");
            orderCart.displayCart();
            System.out.print("\n");
            System.out.printf("Total Price: %.2f", orderCart.calculateTotal());
            System.out.print("\n");

            String changeOrder;
            System.out.print("\n");
            System.out.println("Would you like to change your order?(yes/no)");
            changeOrder = scanner.next();
            do {
                int x;
                int anotherChoice;
                if (changeOrder.equalsIgnoreCase("yes")
                        || changeOrder.equalsIgnoreCase("y")) {

                    while (changeOrder.equalsIgnoreCase("yes")
                            || changeOrder.equalsIgnoreCase("y")) {
                        System.out.print("\n");
                        System.out.println("to remove an item enter: 1\n" +
                                "to add an item enter 2 ");
                        if (scanner.hasNextLine()) {
                            anotherChoice = scanner.nextInt();
                            switch (anotherChoice) {
                                case 1:
                                    System.out.print("\n------------------------------------------------------\n");
                                    orderCart.removeItem(scanner, orderCart);
                                    break;
                                case 2:
                                    System.out.print("\n------------------------------------------------------\n");
                                    menu.displayMenu(RestaurantName);
                                    cart.addToCart(scanner, menu, orderCart);
                                    break;
                                default:
                                    System.out.println("please enter a correct number");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a number from the choices");
                            scanner.next();
                        }
                        System.out.print("\n");
                        System.out.println("Would you like to change your order?(yes/no)");
                        changeOrder = scanner.next();
                    }
                } else if (changeOrder.equalsIgnoreCase("no")
                        || changeOrder.equalsIgnoreCase("n")) {
                    break;
                } else {
                    System.out.println("invalid input try again:");
                    changeOrder = scanner.next();
                }

            } while (changeOrder.equalsIgnoreCase("yes") || changeOrder.equalsIgnoreCase("y") ||
                    changeOrder.equalsIgnoreCase("no") || changeOrder.equalsIgnoreCase("n"));

            System.out.print("\n------------------------------------------------------\n");
            orderCart.displayCart();
            System.out.printf("Total Price: %.2f", orderCart.calculateTotal());

            if (orderCart.getCartSize() > 0) {
                System.out.println("\n------------------------------------------------------\n");

                System.out.println("Please enter delivery time:- ");
                int time = scanner.nextInt();
                System.out.println("To confirm the order press Y");
                System.out.println("To cancel the order press C");
                char con = 'x';
                while (true) {
                    con = scanner.next().charAt(0);
                    if (con == 'Y' || con == 'y' || con == 'c' || con == 'C')
                        break;
                    System.out.println("Invalid");
                    System.out.println("To confirm the order press Y");
                    System.out.println("To cancel the order press C");
                }
                if (con == 'Y' || con == 'y') {
                    System.out.println("Your Order : ");

                    orderCart.displayCart();
                    System.out.println("Total: $" + orderCart.calculateTotal());
                    System.out.println("Your Address : " + loggedInUser.getAddress() + ".");
                    System.out.println("Your order will be prepared. It will reach on " + time + ".");

                    PaymentTest();
                    mainreview();
                }
            }
        } else {

            System.out.println("USER DOESN'T EXIST!");
            System.exit(-1);
        }
    }



    public static void PaymentTest() {
        // Creating a Payment object with initial details
        Payment payment = new Payment(123456, "Pending", "");

        // Testing payment processing
        payment.paymentProcess();

        // Displaying the updated payment details
        System.out.println("Transaction ID: " + payment.getTransactionId());
        System.out.println("Payment Status: " + payment.getPaymentStatus());
        System.out.println("Payment Method: " + payment.getPaymentMethod());
    }

    public static void mainreview() {


        System.out.println("Welcome to the Review System!");

        // Collect user information
        review userReview = new review();
        userReview.setName();
        userReview.setNum_phone();
        userReview.setRev_rest();
        userReview.setRev_staf();
        userReview.setRev_clean();
        userReview.setRev_food();
        userReview.setRev_design();
        userReview.setComments();

        // Specify the file path where you want to save the data
        String filePath = "reviews.txt";

        // Save the data to the file
        userReview.saveToFile(filePath);

        System.out.println("Review saved successfully. Thank you for your feedback!");

    }


    //function that handles program flow after a system administrator logs in
    public static void adminLaunchProgram() {
        Admin sysAdmin = new Admin();

        sysAdmin.runDashboard();
    }

    public static void restaurantLaunchProgram(String restaurantEmail, Restaurant restaurant) {
        ArrayList<String> restaurantData = restaurant.getRestaurantEmail(restaurantEmail);
        String name = restaurantData.get(0);
        String phone = restaurantData.get(1);
        String address = restaurantData.get(2);
        String email = restaurantData.get(3);
        String password = restaurantData.get(4);

        Restaurant loggedInRestaurant = new Restaurant(name, address, phone, email, password);
        Menu restaurantMenu = new Menu();

        Scanner scanner = new Scanner(System.in);
        String exitCheck;
        do {

            System.out.println("\n\t\t####### Restaurant Dashboard ########\n");
            System.out.println("\t\t\t Welcome " + loggedInRestaurant.getRestaurantName() + "!");

            System.out.println("\n##### " + loggedInRestaurant.getRestaurantName() + "'s Menu #####");
            restaurantMenu.readMenuDataFile(loggedInRestaurant.getRestaurantName());
            restaurantMenu.displayMenu(loggedInRestaurant.getRestaurantName());

            System.out.println("\nOptions:\n0.Exit\n" +
                    "1.Add Dish To Menu" +
                    "\n2.View Pending Orders" +
                    "\n3.Generate Business Report For Restaurant");


            int choice;
            do {

                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 0 || choice > 3) {
                        System.out.println("Invalid choice. Please enter a number between 0 and 3.");
                    }
                } catch (NumberFormatException exp) {
                    System.out.println("Invalid input. Please enter a valid number." +
                            " To exit type 0.");
                    choice = -1; // Set choice to an invalid value to trigger the loop again
                }
            } while ((choice < 0 || choice > 3));


            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    restaurant.addDishToMenuPage(loggedInRestaurant);
                    break;
                case 2:
                    restaurant.viewOrders();
                    break;
                case 3:
                    restaurant.generateBusinessReport(loggedInRestaurant);
            }
            System.out.println("Would you like to exit program? (Y/N)");
            exitCheck = scanner.nextLine();
        } while (exitCheck.equalsIgnoreCase("n") || exitCheck.equalsIgnoreCase("no"));
    }
}