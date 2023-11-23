package project.user;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RegistrationSystem
{
    //file for storing users data
    private static final String USER_FILE = "users.txt";
    public void registerUser()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        User user = new User(username,password,email,address);
        storeUserData(user);
    }

    public void storeUserData(User user)
    {
        PrintWriter writer = null;
        try
        {
            //opens file in append mode and stores data with semicolon to seperate them
            writer = new PrintWriter((new FileWriter(USER_FILE,true)));

            writer.write(user.getUsername()        + ";"
                    + user.getPassword()        + ";"
                    + user.getEmail()           + ";"
                    + user.getAddress()         + ";");

        }catch(IOException exp)
        {
            System.out.println(exp.getMessage());
        }
        finally
        {
            if(writer != null)
            {
                writer.close();
            }
        }
    }

}
