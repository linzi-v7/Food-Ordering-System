package project.user;


public class User
{
    private String username;
    private String password;
    private String email;
    private String address;


    public User()
    {
        this.username = null;
        this.password = null;
        this.email = null;
        this.address = null;
    }

    public User(String username, String password, String email, String address)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
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

    public String getAddress()
    {
        return address;
    }


}
