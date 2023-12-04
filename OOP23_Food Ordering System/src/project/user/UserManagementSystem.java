package project.user;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * class to handle user login and registration functions. All functions are static.
 */
public class UserManagementSystem
{
    //data index in users.txt file
    public static final int USER_NAME_INDEX = 0;
    public static final int USER_EMAIL_INDEX = 1;
    public static final int USER_PASSWORD_INDEX = 2;
    public static final int USER_ADDRESS_INDEX = 3;


    //file for storing users data
    //file must not end with \n on a separate line to avoid exceptions
    //if file ended with \n on a separate line, the userdata array thinks it's a row that contains user
    //data which throws an arrayOutOfBounds exception.
    private static final String USER_FILE = "users.txt";

    /**
     * Registers new user, if email input already exists, the users keeps getting prompted
     * to enter a new email. After all credentials are input, a new user is created and
     * stored in the users file (users.txt)
     */
    public static void registerUser() {
        //get input
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t ######## Registration Page ########" +
                "\nAt any point type exit to return to welcome page.");

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        if(checkExit(name))
        {
            return;
        }

        String email;
        int retryCount = 0;
        do {
            if(retryCount >=  1)
            {
                System.out.println("Account Already Exists!");
            }
            System.out.print("Enter E-mail: ");
            email = scanner.nextLine();
            if(checkExit(email))
            {
                return;
            }
            retryCount++;
        } while (checkDuplicateUser(email,USER_EMAIL_INDEX));     //check if account doesn't already exist



        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        if(checkExit(password))
        {
            return;
        }

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        if(checkExit(address))
        {
            return;
        }

        //if account doesn't exist create a new user and store their data
        User user = new User(name, email, password, address);
        storeUserData(user);

    }

    public static void storeUserData(User user)
    {
        try (PrintWriter writer = new PrintWriter((new FileWriter(USER_FILE, true)))) {
            //opens file in append mode and stores data with semicolon to separate them

            writer.write(user.getName() + ";"
                    + user.getEmail() + ";"
                    + user.getPassword() + ";"
                    + user.getAddress() + ";\n");

        } catch (IOException exp) {
            System.out.println(exp.getMessage());
        }
    }


    /**
     * takes a parameter and its index in the users.txt file and checks if value already exists.
     *
     * @param valueToCheck the value to be compared to
     * @param valueIndex index of the value in users.txt (name = 0, email = 1, password = 2, address = 3)
     * @return true if duplicate found, false if no matching value was found
     */
    public static boolean checkDuplicateUser(String valueToCheck, int valueIndex)
    {
        ArrayList<String> usersArray = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(USER_FILE)))
       {
           String row;
           while((row = bufferedReader.readLine()) != null) //reads each line until there is none
           {
               usersArray.add(row);
           }

           for (String s : usersArray)
           {
               String[] userData = s.split(";");
               String value = userData[valueIndex];
               if (value.equals(valueToCheck))
               {
                   return true; // found duplicate value
               }
           }

       }
       catch(IOException exp)
       {
           System.out.println("Couldn't Open file");

       }

        return false;
    }

    /**
     * prompts users to enter email and password and checks if values exist on the same row after each
     * other in users.txt file.
     * @return String of logged in user if available, if not available returns the String "null"
     */
    public static String loginUser()
    {
        System.out.println("\t\t ######## Login Page ########");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if(checkDuplicateUser(email,USER_EMAIL_INDEX)
                && checkDuplicateUser(password,USER_PASSWORD_INDEX))
        {
            System.out.println("Login Successful!");
            return email; //login successful, returns email to use later to get user data
        }
        else
        {
            System.out.println("Credentials wrong");
            return "null"; //login has some kind of error so it returns false
        }
    }

    /**
     * checks if input equals to exit value to exit from function
     * @param input any input (e.g: email,name,password,etc..)
     * @return true if value equal to exit, the caller should handle what happens next
     */
    public static boolean checkExit(String input)
    {
        return input.equalsIgnoreCase("exit"); //returns true if == exit
    }

    /**
     * Function to get user data using the email field.
     *
     * @param userEmail email of the user to be logged in, email is already checked multiple times before
     *                  during other functions, so logically it can't be null.
     * @return a new User object containing the data of the currently logged in user
     */
    public static User getUserByEmail(String userEmail)
    {
        ArrayList<String> usersArray = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(USER_FILE)))
        {
            String row;
            while((row = bufferedReader.readLine()) != null) //reads each line until there is none
            {
                usersArray.add(row);
            }

            for (String s : usersArray)
            {
                String[] userData = s.split(";");
                String value = userData[USER_EMAIL_INDEX];
                if (value.equals(userEmail))
                {
                    String name = userData[USER_NAME_INDEX];
                    String email = userData[USER_EMAIL_INDEX];
                    String password = userData[USER_PASSWORD_INDEX];
                    String address = userData[USER_ADDRESS_INDEX];

                    return new User(name,email,password,address);
                }
            }

        }
        catch(IOException exp)
        {
            System.out.println("Couldn't Open file");

        }

        return null;
    }
}
