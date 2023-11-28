package project.main;

import project.user.RegistrationSystem;
import project.restaurant.restaurantRegistration;
import java.util.Scanner;

public class main
{
    public boolean logged = false;
public static int choice ;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("######## Food Ordering System #############\n");
        System.out.println("to log in as a user press: 1 \nto log in as a restaurant manager press: 2");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("\t\t\t Welcome!\n");
                System.out.println("Do you already have an account? Enter Yes or No");

                String isUserCheck = scanner.nextLine();

                if(      isUserCheck.equalsIgnoreCase("yes")
                        || isUserCheck.equalsIgnoreCase("y"))
                {
                    do
                    {
                        RegistrationSystem.loginUser();
                    }while(!RegistrationSystem.loginUser()); //as long as user enters wrong credentials
                }
                else if (isUserCheck.equalsIgnoreCase("no")
                        || isUserCheck.equalsIgnoreCase("n"))
                {
                    RegistrationSystem.registerUser();

                }
                else
                {
                    System.out.println("Invalid Output");
                }
break;
            case 2:
                System.out.println("\t\t\t Welcome!\n");
                System.out.println("Do you already have an account? Enter Yes or No");
                String isRestaurantCheck = scanner.nextLine();

                if(      isRestaurantCheck.equalsIgnoreCase("yes")
                        || isRestaurantCheck.equalsIgnoreCase("y"))
                {
                    do
                    {
                        restaurantRegistration.registerRestaurant();
                    }while(!restaurantRegistration.registerRestaurant()); //as long as user enters wrong credentials
                }
                else if (isRestaurantCheck.equalsIgnoreCase("no")
                        || isRestaurantCheck.equalsIgnoreCase("n")) {
                    restaurantRegistration.registerRestaurant();

                }
                else
                {
                    System.out.println("Invalid Output");
                }
                break;
            default:
                System.out.println("wrong entry please enter a number");
        }


    }
}