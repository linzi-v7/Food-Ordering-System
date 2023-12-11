package project.user;

import project.admin.Admin;
import project.main.Role;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * class to handle user login and registration functions. All functions are static.
 */
public class UserManagementSystem implements Exit
{
    //IMPORTANT NOTE FOR USERS FILE.
    //FILE MUST NOT END WITH DOUBLE \N TO AVOID ARRAY OUT OF BOUND EXCEPTION
    //if file ended with \n on a separate line, the userdata array thinks it's a row that contains user
    //data which throws an arrayOutOfBounds exception.

    //IF YOU EDIT MANUALLY ON THE USERS FILE, MAKE SURE TO SEPARATE THEM WITH DELIMITER ( ; )
    private static final String USER_FILE = "users.txt";

    //data index in users.txt file
    public static final int USER_NAME_INDEX = 0;
    public static final int USER_EMAIL_INDEX = 1;
    public static final int USER_PASSWORD_INDEX = 2;
    public static final int USER_ADDRESS_INDEX = 3;

    private static ArrayList<String> usersArray = new ArrayList<>();

    public static void readUserDataFile()
    {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(USER_FILE)))
        {
            String row;
            while ((row = bufferedReader.readLine()) != null) //reads each line until there is none
            {
                usersArray.add(row);
            }
        }catch(IOException exp)
        {
            System.out.println(exp.getMessage());
        }
    }


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
        if(Exit.checkExit(name))
        {
            return;
        }

        String email;
        do {
            System.out.print("Enter E-mail: ");
            email = scanner.nextLine();
            if(Exit.checkExit(email))
            {
                return;
            }

            if(checkDuplicateUser(email,USER_EMAIL_INDEX)
                    || email.equalsIgnoreCase("admin"))
            {
                System.out.println("Account Already Exists!");
            }
            else
            {
                break;
            }

        }while (true);     //check if account doesn't already exist or if input admin


        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        if(Exit.checkExit(password))
        {
            return;
        }

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        if(Exit.checkExit(address))
        {
            return;
        }

        //if account doesn't exist create a new user and store their data
        User user = new User(name, email, password, address);
        storeUserData(user);
        System.out.println("Registration Successful!");

    }

    /**
     * stores user data after registering, stores in local arrayList then in file.
     * @param user user to be stored
     */
    public static void storeUserData(User user)
    {

        usersArray.add(user.getName() + ";"
                + user.getEmail() + ";"
                + user.getPassword() + ";"
                + user.getAddress() + ";\n" );

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
        for (String s : usersArray)
        {
            String[] userData = s.split(";");
            String value = userData[valueIndex];
            if (value.equals(valueToCheck))
            {
                return true; // found duplicate value
            }
        }

           return false;
    }

    /**
     * function to check email and password found in user data file
     * @param emailInput  email input by user
     * @param passwordInput password input by user
     * @return true if email and password on the same row are equal to input given, false if not found.
     */
    public static boolean checkDuplicateUser(String emailInput, String passwordInput)
    {
        for (String s : usersArray)
        {
            String[] userData = s.split(";");
            String email = userData[USER_EMAIL_INDEX];
            String password = userData[USER_PASSWORD_INDEX];
            if (email.equals(emailInput) && password.equals(passwordInput))
            {
                return true; // found account credentials
            }
        }

        return false;
    }

    /**
     * prompts users to enter email and password and checks if values exist on the same row after each
     * other in users.txt file.
     * @return String of logged-in user if available, if not available returns the String "null"
     */
    public static String loginUser()
    {
        System.out.println("\t\t ######## Login Page ########");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter E-mail: ");
        String email = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if(isAdmin(email,password))
        {
            System.out.println("Login Successful!");
            Role.setRoleIdentifier(Role.ADMIN_IDENTIFIER);
            return "admin";
        }
        else if(checkDuplicateUser(email,password))
        {
            System.out.println("Login Successful!");
            Role.setRoleIdentifier(Role.USER_IDENTIFIER);
            return email; //login successful, returns email to use later to get user data
        }
        else
        {
            System.out.println("Credentials wrong");
            return "null"; //login has some kind of error so it returns false
        }
    }


    /**
     * Function to get user data using the email field.
     *
     * @param userEmail email of the user to be logged in, email is already checked multiple times before
     *                  during other functions, so logically it can't be null.
     * @return a new User object containing the data of the currently logged-in user
     */
    public static User getUserByEmail(String userEmail)
    {

        for (String s : usersArray)
        {
            String[] userData = s.split(";");
            String storedEmail = userData[USER_EMAIL_INDEX];
            if (storedEmail.equals(userEmail)) {
                String name = userData[USER_NAME_INDEX];
                String email = userData[USER_EMAIL_INDEX];
                String password = userData[USER_PASSWORD_INDEX];
                String address = userData[USER_ADDRESS_INDEX];

                return new User(name, email, password, address);
            }
        }



        return null;
    }

    /**
     * checks if user login input matches administrator credentials.
     * @param email email input by user
     * @param password password input by user
     * @return true if email and password equals to admin credentials, false otherwise.
     */
    public static boolean isAdmin(String email, String password)
    {
        Admin admin = new Admin();
        return email.equals(admin.getEmail())
                && password.equals(admin.getPassword());
    }




}
