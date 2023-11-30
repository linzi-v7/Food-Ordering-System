package project.admin;

import project.restaurant.Restaurant;
import project.restaurant.RestaurantPermissions;
import project.user.UserRegistrationSystem;
import project.user.User;

public interface AdminPermissions extends RestaurantPermissions
{
    default void addUser(String name, String email, String password, String address)
    {
        User user = new User(name,email,password,address);
        UserRegistrationSystem.storeUserData(user);
    }

    default void removeUser(User user)
    {

    }

    default void addRestaurant(String name, String email, String password, String address)
    {

    }

    default void removeRestaurant(Restaurant restaurant)
    {

    }
}
