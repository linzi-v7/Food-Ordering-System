package project.payment;
import java.io.*;
import java.util.Scanner;
/**
 *

 @author Amani Alotaibi*/
public class Payment {
    private int Id;
    private String status;
    private String Payway;
    private String choice;

    public Payment(int Id, String status, String Payway) {
        this.Id = Id;
        this.status = status;
        this.Payway = Payway;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayway() {
        return Payway;
    }

    public void setPayway(String Payway) {
        this.Payway = Payway;
    }

    public String getchoice() {
        return choice;
    }

    public void setchoice(String choice) {
        this.choice = choice;
    }

    public void Payment_process() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose your preferred payment way:");
        System.out.println("(credit card)");
        System.out.println("(Debit card)");
        System.out.println("(digital wallet)");
        System.out.println("-------------------------------------------------------------------------------------");
        String choice = scan.next();
        switch (choice) {
            case credit card: {

            }
            break;
            case Debit card: {

            }
            break;
            case digital wallet: {

            }
        }
    }
}