package project.user;

public class testmain
{
    public static void main(String[] args) {
        User customer = new User("farixs","osama","faris@gmail","n9");
        RegistrationSystem registrator = new RegistrationSystem();
        registrator.registerUser(customer);
    }
}
