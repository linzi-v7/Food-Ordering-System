package project.user;

/**
 * User class. Each user contains name, password, email and an address.
 * has only one parameterized constructor to initialize these values.
 */
public class User implements Comparable
{
    private String name;
    private String password;
    private String email;
    private String address;


    public User(String name, String email, String password, String address)
    {
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;

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


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        User otherUser = (User) o;
        if(this.name.compareTo(otherUser.name) > 0)
        {
            return 1;
        }else if(this.name.compareTo(otherUser.name) < 0)
        {
            return -1;
        }
        else {
            return 0;
        }

    }
}
