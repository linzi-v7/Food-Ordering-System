package project.user;


public class User
{
    private String name;
    private String password;
    private String email;
    private String address;
    private int userID;
    private static int userIDsequence = 250;

    public User(String name, String email, String password, String address)
    {
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        userID = userIDsequence;

        userIDsequence++;
    }

    public String getName()
    {
        return name;
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
