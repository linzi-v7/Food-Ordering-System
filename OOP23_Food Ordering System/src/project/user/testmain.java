package project.user;

public class testmain
{
    public static void main(String[] args) {
        User customer = new User("farixs","osama","faris@gmail","n9");
        customer.registerUser(customer.username, customer.password, customer.email, customer.deliveryAddress);
    }
}
