package project.admin;

import project.restaurant.RestaurantPermissions;
import project.user.UserManagementSystem;
import project.user.User;

import java.io.*;
import java.util.ArrayList;

public interface AdminPermissions extends RestaurantPermissions
{
    default void addUser(String name, String email, String password, String address)
    {
        User user = new User(name,email,password,address);
        UserManagementSystem.storeUserData(user);
    }

    default void removeUser(String userEmailToRemove)
    {
        final String USER_FILE = "users.txt";

        ArrayList<String> rows = new ArrayList<>();

        //read users from file
        try(BufferedReader reader = new BufferedReader(new FileReader(USER_FILE)))
        {
            String row;
            while((row = reader.readLine())!= null)
            {
                rows.add(row);
            }
        }catch(IOException exp)
        {
            exp.getMessage();
        }

        //check if user exists and remove from arrayList
        boolean userFound = false;
        for (int i =0; i < rows.size(); i++)
        {
            String[] userData = rows.get(i).split(";");
            String userEmail = userData[1];
            if(userEmail.equals(userEmailToRemove))
            {
                rows.remove(i);
                userFound = true;
                break;
            }
        }

        //if user exists, rewrite file using updated arrayList without the removed user.
        if(userFound)
        {
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(USER_FILE)))
            {
                for(String row: rows)
                {
                    writer.write(row);
                    writer.newLine();
                }
            }catch(IOException exp)
            {
                exp.getMessage();
            }
        }
        else
        {
            System.out.println("User Doesn't Exist!");
        }


    }
/*
    default void addRestaurant(String name, String email, String password, String address)
    {
        //RestaurantRegistration(......)
    }

    default void removeRestaurant(Restaurant restaurant)
    {
        //same logic of remove user
    }

 */
}
