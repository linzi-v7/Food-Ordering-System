package project.user;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class User
{
    protected String username;
    protected String password;
    protected String email;
    protected String deliveryAddress;

    //file for storing users data
    private static final String USER_FILE = "users.txt";
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

    public void registerUser(String username, String password, String email,String deliveryAddress)
    {
        PrintWriter writer = null;
        try
        {
            //opens file in append mode and stores data with semicolon to seperate them
            writer = new PrintWriter((new FileWriter(USER_FILE,true)));
            writer.write(username + ";" + password + ";" + email + ";" + ";" + deliveryAddress);

        }catch(IOException exp)
        {
            System.out.println(exp.getMessage());
        }
        finally
        {
           if(writer != null)
           {
               writer.close();
           }
        }
    }
}
