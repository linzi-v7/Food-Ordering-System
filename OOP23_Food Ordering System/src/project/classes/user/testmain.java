package project.classes.user;

public class testmain
{
    public static void main(String[] args) {
        Customer customer = new Customer("farixs","osama","faris@gmail","n9");
        customer.registerUser(customer.username, customer.password, customer.email);
    }
}
