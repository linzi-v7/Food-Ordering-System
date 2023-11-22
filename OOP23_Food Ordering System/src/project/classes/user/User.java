package project.classes.user;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class User
{
    protected String username;
    protected String password;
    protected String email;

    private static final String USER_FILE = "users.txt";
    public User()
    {
        this.username = null;
        this.password = null;
        this.email = null;
    }

    public User(String username, String password, String email)
    {
        this.username = username;
        this.password = password;
        this.email = email;
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

    public void registerUser(String username, String password, String email)
    {
        PrintWriter writer = null;
        try
        {
            writer = new PrintWriter((new FileWriter(USER_FILE)));
            writer.write(username + ";" + password + ";" + email + ";");

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
