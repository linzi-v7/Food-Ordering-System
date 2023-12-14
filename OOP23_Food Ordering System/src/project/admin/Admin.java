package project.admin;


import project.user.InputChecks;
import project.user.User;
import project.user.UserManagementSystem;

import java.util.Scanner;

public class Admin extends User implements AdminPermissions, InputChecks
{

    public Admin()
    {
        super("System Administrator", "admin@gmail.com", "admin123", "HQ","123456789");
    }

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

    void addUserPage() {
        UserManagementSystem.registerUser(2);
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

}
