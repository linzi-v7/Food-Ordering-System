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
    private String phoneNumber;


    public User(String name, String email, String password, String address,String phoneNumber)
    {
        this.name = name;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress()
    {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
