package project.user;

import java.io.*;
import java.util.Scanner;

public class RegistrationSystem
{
    //file for storing users data
    private static final String USER_FILE = "users.txt";
    public void registerUser() {
        //get input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        String email;
        int retryCount = 0;
        //THIS FUNCTION IS NOT WORKING YET.
        do {
            if(retryCount >=  1)
            {
                System.out.println("Account Already Exists!");
            }
            System.out.print("Enter E-mail: ");
            email = scanner.nextLine();

            retryCount++;
        } while (checkDuplicateEmail(email));     //check if account doesn't already exist



        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        //if account doesn't exist create a new user and store their data
        User user = new User(name, password, email, address);
        storeUserData(user);
    }

    public void storeUserData(User user)
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

    public boolean checkDuplicateEmail(String email)
    {

       try(BufferedReader bufferedReader = new BufferedReader(new FileReader(USER_FILE)))
       {
           String [][] usersArray = new String[10][3];
           String line;
           int row = 0;
           while((line = bufferedReader.readLine()) != null)
           {
               String[] values = line.split(";");
               usersArray[row] = values;
               row++;
           }

           for (int i =0; i<10 ;i++)
           {
              if(usersArray[i][2].equals(email))
              {
                  return true; // found duplicate email;
              }

           }

       }
       catch(IOException exp)
       {
           System.out.println("Couldn't Open file");

       }

        return false;
    }
}
