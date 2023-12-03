package project.admin;

import java.util.Scanner;

public class Admin implements AdminPermissions
{
    private final static String username ="admin";
    private final static String password ="admin123";

    void runDashboard()
    {
        System.out.println("\t\t####### Admin Dashboard ########");
        System.out.println("Options:\n1.Add User\n2.Remove User\n.......");

        Scanner reader = new Scanner(System.in);

        int choice = Integer.parseInt(reader.nextLine());

        switch (choice)
        {
            case 1:
                System.out.println("Enter User Data (Name,Email,Password,Address)");

                String name = reader.nextLine();
                String email = reader.nextLine();
                String password = reader.nextLine();
                String address = reader.nextLine();

                addUser(name,email,password,address);
                break;

            case 2:
                System.out.print("Enter User's Email To Be Removed: ");
                String emailToRemove = reader.nextLine();
                removeUser(emailToRemove);
                break;
        }
    }
}
