package project.main;
import project.restaurant.Restaurant;

import project.restaurant.restaurantRegistration;
import project.admin.Admin;
import project.user.User;
import project.user.UserManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class main
{
    public static void main(String[] args)
    {
        UserManagementSystem.readUserDataFile();
        Scanner scanner = new Scanner(System.in);
        String userEmail = null;
        Restaurant restaurant = new Restaurant();
restaurant.loadRestaurantsFromFile("restaurant.txt");
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
                    if ( (userEmail=UserManagementSystem.loginUser(restaurant)).equals("null"))
                    {
                        System.out.println("Would you like to retry?(Y/N)");
                        retry = scanner.nextLine();
                    }
                    //prompts user to retry if they entered wrong credentials
                } while (retry.equalsIgnoreCase("y")
                        || retry.equalsIgnoreCase("yes"));

            } else if (isUserCheck.equalsIgnoreCase("no")
                    || isUserCheck.equalsIgnoreCase("n")) {
                int decision ;

                System.out.println("to register as  new user enter: 1\n" +
                        "to register as a new restaurant enter 2 ");
                decision= scanner.nextInt();
                switch (decision)
                {
                case 2:

                    restaurantRegistration.registerRestaurant(restaurant);
                    break;
                case 1:
                   UserManagementSystem.registerUser(1);

                    break;
                   
                default:
                    System.out.println("please enter a correct number");
            }
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
                //restaurantLaunchProgram(restaurant);
                break;
            case Role.USER_IDENTIFIER:
                userLaunchProgram(userEmail,restaurant);

        }


    }

    //function to handle program flow after project.project.admin.admin.user logs in, should display restaurants, menus,etc..
    public static void userLaunchProgram(String userEmail,Restaurant restaurant)
    {
        User loggedInUser = UserManagementSystem.getUserByEmail(userEmail);

        //if somehow the project.project.admin.admin.user doesn't exist (after multiple checks), we should terminate the program
        if (loggedInUser != null)
        {
            Scanner scanner = new Scanner(System.in);
int ChosenRestaurant;
            System.out.println("\n\t\tWelcome " + loggedInUser.getName() + "!");

            System.out.println("select what you want to do and enter the number of the operation that you want.");
            System.out.println("to display all restaurants enter: 1");
            System.out.println("to search for a specific restaurant enter: 2");
while(true) {
    int decision = scanner.nextInt();
    switch (decision) {
        case 1:
            int counter = 0;
            for (ArrayList<String> restaurants : restaurant.getRestaurants()) {
                counter++;
                System.out.println(counter + "." + restaurants.get(0));

            }
            System.out.println("\n\n" + "enter the number of the restaurant that you want");
            ChosenRestaurant = scanner.nextInt();
            break;

        case 2:
            restaurant.restaurantSearching(restaurant);
            break;

        default:
            System.out.println("choose a value that exists within the choices");

    }

    System.out.println("enter the number of the restaurant that you want");
}
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
        Admin sysAdmin = new Admin();

        sysAdmin.runDashboard();
    }



}
