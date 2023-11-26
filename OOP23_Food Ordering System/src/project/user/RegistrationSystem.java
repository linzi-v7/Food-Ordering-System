package project.user;

import java.io.*;
import java.util.Scanner;

public class RegistrationSystem
{
    //file for storing users data
    //file must not end with \n on a seperate line to avoid exceptions
    //if file ended with \n on a seperate line, the userdata array thinks its a row that contains user
    //data which throws an arrayoutofbounds exception.
    private static final String USER_FILE = "users.txt";
    public static void registerUser() {
        //get input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        String email;
        int retryCount = 0;
        do {
            if(retryCount >=  1)
            {
                System.out.println("Account Already Exists!");
            }
            System.out.print("Enter E-mail: ");
            email = scanner.nextLine();

            retryCount++;
        } while (checkDuplicate(email,1));     //check if account doesn't already exist



        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        //if account doesn't exist create a new user and store their data
        User user = new User(name, email, password, address);
        storeUserData(user);
    }

    public static void storeUserData(User user)
    {
        try (PrintWriter writer = new PrintWriter((new FileWriter(USER_FILE, true)))) {
            //opens file in append mode and stores data with semicolon to seperate them

            writer.write(user.getName() + ";"
                    + user.getPassword() + ";"
                    + user.getEmail() + ";"
                    + user.getAddress() + ";\n");

        } catch (IOException exp) {
            System.out.println(exp.getMessage());
        }
    }

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
               }catch(ArrayIndexOutOfBoundsException exp) //if file ended with \n on a seperate line
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

    public static boolean loginUser()
    {
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
}
