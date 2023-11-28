package project.payment;
import java.io.*;
import java.util.Scanner;
/**
 *

 @author Amani Alotaibi*/
public class Payment {
    private int id;
    private String status;
    private String payway;
    private String choice;

    public Payment(int id, String status, String payway) {
        this.id = id;
        this.status = status;
        this.payway = payway;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayway() {
        return payway;
    }

    public void setPayway(String payway) {
        this.payway = payway;
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
//        switch (choice) {
//           case credit card: {
//
//            }
//            break;
//            case Debit card: {
//
//            }
//            break;
//            case digital wallet: {
//
//            }
//        }
    }
}