package project.classes.user;

public class Customer extends User
{
    protected String deliveryAddress;

    public Customer()
    {
        this.deliveryAddress = null;
    }

    public Customer(String username, String password, String email, String deliveryAddress)
    {
        super(username, password, email);
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryAddress()
    {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress)
    {
        this.deliveryAddress = deliveryAddress;
    }
}
