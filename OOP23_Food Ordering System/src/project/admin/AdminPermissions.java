package project.admin;

import project.restaurant.RestaurantPermissions;
import project.user.UserManagementSystem;
import project.user.User;



public interface AdminPermissions extends RestaurantPermissions
{
    default void addUser(String name, String email, String password, String address)
    {
        User user = new User(name,email,password,address);
        UserManagementSystem.storeUserData(user);
    }

    default void removeUser(String userEmailToRemove)
    {
     UserManagementSystem.removeUser(userEmailToRemove);
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
