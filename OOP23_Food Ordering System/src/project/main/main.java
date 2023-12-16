package project.main;

import project.admin.Admin;
import project.user.User;
import project.user.UserManagementSystem;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        UserManagementSystem.readUserDataFile();

        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        String userEmail = null;


        do
        {
            System.out.println("\t####### Food Ordering System #######\n");
            System.out.println("\t\t\t\t Welcome!\n");
            System.out.println("Do you already have an account? Enter Yes or No\n" +
                    "Type exit to close program.");

            String isUserCheck = scanner.nextLine();


            if (isUserCheck.equalsIgnoreCase("yes")
                    || isUserCheck.equalsIgnoreCase("y"))
            {
                String retry;
                do
                {
                    retry = "n";
                    if ( (userEmail=UserManagementSystem.loginUser()).equals("null"))
                    {
                        System.out.println("Would you like to retry?(Y/N)");
                        retry = scanner.nextLine();
                    }
                    //prompts user to retry if they entered wrong credentials
                } while (retry.equalsIgnoreCase("y")
                        || retry.equalsIgnoreCase("yes"));

            } else if (isUserCheck.equalsIgnoreCase("no")
                    || isUserCheck.equalsIgnoreCase("n"))
            {

                UserManagementSystem.registerUser(1);
            }
            else if(isUserCheck.equalsIgnoreCase("exit"))
            {
                System.exit(0);
            }
            else
            {
                System.out.println("Invalid Input");
            }
        }while(Role.getRoleIdentifier() == 0);


        switch (Role.getRoleIdentifier())
        {
            case Role.ADMIN_IDENTIFIER:
                adminLaunchProgram();
                break;
            case Role.RESTAURANT_IDENTIFIER:
                //restaurantLaunchProgram();
                break;
            case Role.USER_IDENTIFIER:
                userLaunchProgram(userEmail);

        }


    }

    //function to handle program flow after user logs in, should display restaurants, menus,etc..
    public static void userLaunchProgram(String userEmail)
    {
        User loggedInUser = UserManagementSystem.getUserByEmail(userEmail);

        //if somehow the user doesn't exist (after multiple checks), we should terminate the program
        if (loggedInUser != null)
        {
            System.out.println("\n\t\tWelcome " + loggedInUser.getName() + "!");
            System.out.println("Restaurants Near You:");
            //displayRestaurants();
            //chooseRestaurant();
            //displayMenu();
            //addToCart();
            //orderProcessing();

        while (true) {
            System.out.println("1. Place Order");
            System.out.println("2. View Orders");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    main.placeOrderFromUserInput(scanner);
                    break;
                case 2:
                    main.viewOrders();
                    break;
                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void placeOrderFromUserInput(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter the number of items to order: ");
        int numItems = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        List<String> items = new ArrayList<>();
        for (int i = 1; i <= numItems; i++) {
            System.out.print("Enter item " + i + ": ");
            String item = scanner.nextLine();
            items.add(item);
        }

        placeOrder(username, items);
    }

            //paymentProcessing();
            //orderTracking();
            //reviewProcessing();
            
        Scanner scanner = new Scanner(System.in);

        // Create an instance of the review class
        review review = new review();

        // Set values using user input
        review.setName();
        review.setNum_phone();
        review.setRev_rest();
        review.setRev_staf();
        review.setRev_clean();
        review.setRev_food();
        review.setRev_design();
        review.setComments();

        // Specify the file path where you want to save the data
        String filePath = "C:/test.txt";

        // Save the data to the file
        review.saveToFile(filePath);
    }
}

            // loop

        }
        else
        {
            System.out.println("USER DOESN'T EXIST!");
            System.exit(-1);
        }
    }


    //function that handles program flow after a system administrator logs in
    public static void adminLaunchProgram()
    {
        User admin = new Admin();
        Admin sysAdmin = (Admin) admin;

        sysAdmin.runDashboard();
    }


