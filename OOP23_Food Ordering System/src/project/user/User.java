package project.user;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class User
{
    private String username;
    private String password;
    private String email;
    private String deliveryAddress;


    public User()
    {
        this.username = null;
        this.password = null;
        this.email = null;
        this.deliveryAddress = null;
    }

    public User(String username, String password, String email, String deliveryAddress)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.deliveryAddress = deliveryAddress;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getEmail()
    {
        return email;
    }

    public String getDeliveryAddress()
    {
        return deliveryAddress;
    }


}
