package project.user;

import java.io.*;
import java.util.Scanner;

/**
 * class to handle user login and registration functions. All functions are static.
 */
public class RegistrationSystem
{
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
        } while (checkDuplicate(email,1));     //check if account doesn't already exist



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
                    + user.getPassword() + ";"
                    + user.getEmail() + ";"
                    + user.getAddress() + ";\n");

        } catch (IOException exp) {
            System.out.println(exp.getMessage());
        }
    }


    /**
     * takes a parameter and its index in the users.txt file and checks if value already exists.
     *
     * @param checkedValue the value to be compared to
     * @param valueIndex index of the value in users.txt (name = 0, email = 1, password = 2, address = 3)
     * @return true if duplicate found, false if no matching value was found
     */
    public static boolean checkDuplicate(String checkedValue,int valueIndex)
    {

       try(BufferedReader bufferedReader = new BufferedReader(new FileReader(USER_FILE)))
       {
           String [][] usersArray = new String[10][4]; //array to load user data from file to array
           String line;
           int row = 0;
           while((line = bufferedReader.readLine()) != null) //reads each line until there is none
           {
               String[] values = line.split(";"); //needs to split them to remove the delimiter
               usersArray[row] = values;
               row++;
           }

           for (int i =0; i<10 ;i++)
           {
               try {
                   if (usersArray[i][valueIndex].equals(checkedValue))
                   {
                       return true; // found duplicate email
                   }
               }catch(ArrayIndexOutOfBoundsException exp) //if file ended with \n on a separate line
               {
                   return false;
               }
               catch(NullPointerException exp) //if reached the end of the array
               {
                   return false;
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
     * @return true if login was successful, false if not.
     */
    public static boolean loginUser()
    {
        System.out.println("\t\t ######## Login Page ########");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if(checkDuplicate(email,1)
                && checkDuplicate(password,2))
        {
            System.out.println("Login Successful!");
            return true; //login successful
        }
        else
        {
            System.out.println("Credentials wrong");
            return false; //login has some kind of error so it returns false
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
}
