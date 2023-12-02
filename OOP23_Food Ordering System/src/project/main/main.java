package project.main;

import project.user.UserRegistrationSystem;

import java.util.Scanner;

public class main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);


        boolean userLoggedin = false;
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
                String retry = "";
                do
                {
                    if (!UserRegistrationSystem.loginUser())
                    {
                        System.out.println("Would you like to retry?(Y/N)");
                        retry = scanner.nextLine();
                    }else
                    {
                        userLoggedin = true;
                        userLaunchProgram();
                    }
                    //prompts user to retry if they entered wrong credentials
                } while (retry.equalsIgnoreCase("y")
                        || retry.equalsIgnoreCase("yes"));

            } else if (isUserCheck.equalsIgnoreCase("no")
                    || isUserCheck.equalsIgnoreCase("n"))
            {
                UserRegistrationSystem.registerUser();
            }
            else if(isUserCheck.equalsIgnoreCase("exit"))
            {
                System.exit(0);
            }
            else
            {
                System.out.println("Invalid Output");
            }
        }while(!userLoggedin);
    }

    //function to handle program flow after user logs in, should display restaurants,menus,etc..
    public static void userLaunchProgram()
    {

    }
}

