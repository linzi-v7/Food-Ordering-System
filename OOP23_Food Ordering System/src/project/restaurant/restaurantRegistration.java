package restaurant;
import java.sql.SQLOutput;
import java.util.Scanner;
public class restaurantRegistration
{
    private static final String USER_FILE = "restaurants.txt";
public static boolean again= false;
public int decision;

public restaurantRegistration(int decision,boolean again)
{
    this.again=again;
    this.decision=decision;
}
//variable to give user option to re-enter their mails,passwords,emails,phone numbers
    public static void registerRestaurant()
    {
        Scanner scanner = new Scanner(System.in);
        do
        {
            System.out.print("Enter restaurant name: ");
            String restaurantName = scanner.nextLine();
            if (scanner.nextLine().length() == 12);
            System.out.println("out of bounds");
            // checks the length of the phone number
            if(scanner.hasNextInt()){
                System.out.println("number entered exists");
            }
            else{
                System.out.println("please enter a correct number");
            }
            //checks if input is a number
            System.out.print("do you want to change the restaurant name ");
            String decision = scanner.nextLine();
            if (decision.equals("yes")) {
                again = true;

            } else if (decision.equals("Yes")) {
                again = true;
            }
        }while(again);
        again= false;

        do
        {
            System.out.print("Enter restaurant address ");
            String restaurantAddress = scanner.nextLine();
            System.out.print("do you want to change the address ");
            String decision = scanner.nextLine();
            if (decision.equals("yes")) {
                again = true;

            } else if (decision.equals("Yes")) {
                again = true;
            }
        }while(again);
        again= false;


        do
        {
            System.out.print("Enter restaurant contact ");
            int restaurantContact = scanner.nextInt();
            
            System.out.print("do you want to change the contact ");
            String decision = scanner.nextLine();
            if (decision.equals("yes")) {
                again = true;

            } else if (decision.equals("Yes")) {
                again = true;
            }
        }while(again);
        again= false;
        do
        {
            System.out.print("Enter restaurant Email ");
            String restaurantEmail = scanner.nextLine();
            System.out.print("do you want to change the Email ");
            String decision = scanner.nextLine();
            if (decision.equals("yes")) {
                again = true;

            } else if (decision.equals("Yes")) {
                again = true;
            }
        }while(again);
        again= false;
    }

}
