package project.main;

import project.user.RegistrationSystem;

import java.util.Scanner;

public class main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("######## Food Ordering System #############\n");
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

    }
}
