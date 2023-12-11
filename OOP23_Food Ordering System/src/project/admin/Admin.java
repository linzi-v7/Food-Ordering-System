package project.admin;

import project.user.Exit;
import project.user.UserManagementSystem;

import java.util.Scanner;

public class Admin implements AdminPermissions, Exit
{
    private final String email ="admin";
    private final String password ="admin123";

    public void runDashboard()
    {
        Scanner scanner = new Scanner(System.in);
        String exitCheck;
        do {
            exitCheck = "N";

            System.out.println("\t\t####### Admin Dashboard ########\n");
            System.out.println("\t\tWelcome System Administrator!\n");
            System.out.println("\t\tSYSTEM HEALTH: GREAT\n"); //for realism only

            System.out.println("Options:\n0.Exit\n1.Add User\n2.Remove User\n" +
                    "3.Add Restaurant\n4.Remove Restaurant\n5.Add Dish To Menu\n" +
                    "6.Remove Dish From Menu\n7.Update Dish Price" +
                    "\n8.View Pending Orders Of Specific Restaurant" +
                    "\n9.Generate Business Report For Restaurant");


            int choice;
            do {

                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 0 || choice > 2) {
                        System.out.println("Invalid choice. Please enter a number between 0 and 2.");
                    }
                } catch (NumberFormatException exp) {
                    System.out.println("Invalid input. Please enter a valid number." +
                            " To exit type 0.");
                    choice = -1; // Set choice to an invalid value to trigger the loop again
                }
            }while((choice < 0 || choice > 2));


            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    addUserPage();
                    break;

                case 2:
                    removeUserPage();
                    break;
            }
            System.out.println("Would you like to exit program? (Y/N)");
            exitCheck = scanner.nextLine();
        }while(exitCheck.equalsIgnoreCase("n") || exitCheck.equalsIgnoreCase("no"));
    }

    void addUserPage()
    {
        Scanner reader = new Scanner(System.in);

        System.out.println("\t\t#### ADMIN ADD USER PAGE ###");

        System.out.print("Enter user name: ");
        String name = reader.nextLine();
        if(Exit.checkExit(name))
        {
            return;
        }

        do
        {
            System.out.print("Enter user mail: ");
            String email = reader.nextLine();
            if(Exit.checkExit(email))
            {
                return;
            }

            if(UserManagementSystem.checkDuplicateUser(email,
                    UserManagementSystem.USER_EMAIL_INDEX))
            {
                System.out.println("Email already exists!");
            }
            else
            {
                break;
            }
        }while(true);

        System.out.print("Enter user password: ");
        String password = reader.nextLine();
        if(Exit.checkExit(password))
        {
            return;
        }

        System.out.print("Enter user address: ");
        String address = reader.nextLine();
        if(Exit.checkExit(address))
        {
            return;
        }

        addUser(name,email,password,address);

        System.out.println("User Added Successfully!");
    }

    void removeUserPage()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\t\t#### ADMIN REMOVE USER PAGE ###");
        System.out.print("Enter User's Email To Be Removed: ");
        String emailToRemove = scanner.nextLine();

        removeUser(emailToRemove);
        System.out.println("USER REMOVED SUCCESSFULLY!");

    }
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
