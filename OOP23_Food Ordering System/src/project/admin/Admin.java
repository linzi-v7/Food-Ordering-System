package project.admin;


import project.menu.Menu;
import project.restaurant.Restaurant;
import project.restaurant.RestaurantPermissions;
import project.user.InputChecks;
import project.user.User;
import project.user.UserManagementSystem;

import java.util.Scanner;

public class Admin extends User implements AdminPermissions, InputChecks, RestaurantPermissions
{

    public Admin()
    {
        super("System Administrator", "admin", "admin123", "HQ","123456789");
    }

    public void runDashboard()
    {

        Scanner scanner = new Scanner(System.in);
        String exitCheck;
        do {

            System.out.println("\t\t####### Admin Dashboard ########\n");
            System.out.println("\t\tWelcome System Administrator!\n");
            System.out.println("\t\tSYSTEM HEALTH: GREAT\n"); //for realism only

            System.out.println("Options:\n0.Exit\n1.Add User\n2.Add User With No Restrictions.\n3.Remove User\n" +
                    "4.Add Restaurant\n5.Add Dish To Menu" +
                    "\n6.View Pending Orders" +
                    "\n7.Generate Business Report For Restaurant");


            int choice;
            do {

                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 0 || choice > 7) {
                        System.out.println("Invalid choice. Please enter a number between 0 and 7.");
                    }
                } catch (NumberFormatException exp) {
                    System.out.println("Invalid input. Please enter a valid number." +
                            " To exit type 0.");
                    choice = -1; // Set choice to an invalid value to trigger the loop again
                }
            }while((choice < 0 || choice > 7));


            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    addUserPage();
                    break;
                case 2:
                    addUserNoRestrictionsPage();
                    break;
                case 3:
                    removeUserPage();
                    break;
                case 4:
                    addRestaurantPage();
                    break;
                case 5:
                    addDishToMenuPage();
                    break;
                case 6:
                    viewOrders();
                    break;
                case 7:
                    System.out.print("Enter Restaurant Name: ");
                    String restaurantName = scanner.nextLine();
                    if(InputChecks.checkExit(restaurantName))
                    {
                        break;
                    }

                Restaurant restaurantReport = new Restaurant(restaurantName);
                    generateBusinessReport(restaurantReport);
            }
            System.out.println("Would you like to exit program? (Y/N)");
            exitCheck = scanner.nextLine();
        }while(exitCheck.equalsIgnoreCase("n") || exitCheck.equalsIgnoreCase("no"));
    }

    void addUserPage() {
        UserManagementSystem.registerUser(2);
    }

    void addUserNoRestrictionsPage()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t##### Admin Add User Page (NO RESTRICTIONS) #####\n");
        System.out.println("NOTE: ADDING A USER THIS WAY COULD RESULT IN DUPLICATE USERS" +
                " AND IS MORE LIKELY TO CAUSE AN ERROR.\n\t\t\t\t\t\tUSE WITH CAUTION!\n");

        System.out.println("At Any Point Type exit to return.\n");

        System.out.print("Enter User Name: ");
        String name = scanner.nextLine();
        if(InputChecks.checkExit(name))
        {
            return;
        }


        System.out.print("Enter User Email: ");
        String email = scanner.nextLine();
        if(InputChecks.checkExit(email))
        {
            return;
        }


        System.out.print("Enter User Password: ");
        String password = scanner.nextLine();
        if(InputChecks.checkExit(password))
        {
            return;
        }


        System.out.print("Enter User Address: ");
        String address = scanner.nextLine();
        if(InputChecks.checkExit(address))
        {
            return;
        }

        System.out.print("Enter User Phone: ");
        String phone = scanner.nextLine();
        if(InputChecks.checkExit(phone))
        {
            return;
        }

        System.out.println("\nUser Added Successfully!");
        addUser(name,email,password,address,phone);
    }

    void removeUserPage()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\t\t#### ADMIN REMOVE USER PAGE ###\nAt Any Point Type exit to return.\n");
        System.out.print("Enter User's Email To Be Removed: ");
        String emailToRemove = scanner.nextLine();
        if(InputChecks.checkExit(emailToRemove))
        {
            return;
        }

        if (removeUser(emailToRemove))
        {
            System.out.println("USER REMOVED SUCCESSFULLY!");
        }
    }

    void addRestaurantPage()
    {


        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t### Admin Restaurant Registration Page ###\nAt Any Point Type exit to return.\n");

        System.out.print("Enter Restaurant Name: ");
        String name = scanner.nextLine();
        if(InputChecks.checkExit(name))
        {
            return;
        }


        System.out.print("Enter Restaurant Address: ");
        String address = scanner.nextLine();
        if(InputChecks.checkExit(address))
        {
            return;
        }

        System.out.print("Enter Restaurant Contact: ");
        String contact = scanner.nextLine();
        if(InputChecks.checkExit(contact))
        {
            return;
        }

        System.out.print("Enter Restaurant Email: ");
        String email = scanner.nextLine();
        if(InputChecks.checkExit(email))
        {
            return;
        }

        System.out.print("Enter Restaurant Password: ");
        String password = scanner.nextLine();
        if(InputChecks.checkExit(password))
        {
            return;
        }

        Restaurant restaurant = new Restaurant(name,address,contact,email,password);
        restaurant.loadRestaurantsFromFile();
        addRestaurant(restaurant);
        restaurant.RestaurantSaveToFiles(restaurant.getRestaurants());


    }

    void addDishToMenuPage()
    {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t### Admin Add Dish To Menu Page ###\nAt Any Point Type exit to return.\n");

        System.out.print("Enter Restaurant Name: ");
        String restaurantName = scanner.nextLine();
        if(InputChecks.checkExit(restaurantName))
        {
            return;
        }
        menu.readMenuDataFile(restaurantName);

        System.out.print("Enter Dish Name: ");
        String dishName = scanner.nextLine();
        if(InputChecks.checkExit(dishName))
        {
            return;
        }

        System.out.print("Enter Dish Price (0 to abort): ");
        Double dishPrice = Double.parseDouble(scanner.nextLine());
        if(dishPrice == 0)
        {
            return;
        }

        menu.addNewDish(restaurantName,dishName,dishPrice);
        menu.writeMenuDataFile();
    }

}
