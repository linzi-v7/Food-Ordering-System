package project.admin;

import project.restaurant.Restaurant;
import project.restaurant.RestaurantPermissions;
import project.user.UserManagementSystem;
import project.user.User;



public interface AdminPermissions extends RestaurantPermissions
{
    default void addUser(String name, String email, String password, String address,String phoneNumber)
    {
        User user = new User(name,email,password,address,phoneNumber);
        UserManagementSystem.storeUserData(user);
    }

    default boolean removeUser(String userEmailToRemove)
    {
     return UserManagementSystem.removeUser(userEmailToRemove);
    }

    default void addRestaurant(Restaurant restaurant)
    {
        restaurant.addRestaurantDetails(restaurant.getRestaurantName(),
                restaurant.getRestaurantContact(), restaurant.getRestaurantAddress(),
                restaurant.getRestaurantEmail(), restaurant.getRestaurantPassword());

    }

}
