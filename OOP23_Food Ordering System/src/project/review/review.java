package project.review;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;

public class review {
    private String Name = "null";
    private String num_phone = "null";
    private float rev_rest = 0;
    private float rev_staf = 0;
    private float rev_clean = 0;
    private float rev_food = 0;
    private float rev_design = 0;
    private String comments;
    private Scanner scanner = new Scanner(System.in);

    //constructors
    public review() {
    }

    public review(String name, String num_phone) {
        this.Name = name;
        this.num_phone = num_phone;
    }

    public review(String name, String num_phone, float rev_rest) {
        this.Name = name;
        this.num_phone = num_phone;
        this.rev_rest = rev_rest;
    }

    public review(String name, String num_phone, float rev_rest, float rev_staf) {
        this.Name = name;
        this.num_phone = num_phone;
        this.rev_rest = rev_rest;
        this.rev_staf = rev_staf;
    }

    public review(String name, String num_phone, float rev_rest, float rev_staf, float rev_clean) {
        this.Name = name;
        this.num_phone = num_phone;
        this.rev_rest = rev_rest;
        this.rev_staf = rev_staf;
        this.rev_clean = rev_clean;
    }

    public review(String name, String num_phone, float rev_rest, float rev_staf, float rev_clean, float rev_food) {
        this.Name = name;
        this.num_phone = num_phone;
        this.rev_rest = rev_rest;
        this.rev_staf = rev_staf;
        this.rev_clean = rev_clean;
        this.rev_food = rev_food;
    }

    public review(String name, String num_phone, float rev_rest, float rev_staf, float rev_clean, float rev_food, float rev_design) {
        this.Name = name;
        this.num_phone = num_phone;
        this.rev_rest = rev_rest;
        this.rev_staf = rev_staf;
        this.rev_clean = rev_clean;
        this.rev_food = rev_food;
        this.rev_design = rev_design;
    }

    public review(String name, String num_phone, float rev_rest, float rev_staf, float rev_clean, float rev_food, float rev_design, String comments) {
        this.Name = name;
        this.num_phone = num_phone;
        this.rev_rest = rev_rest;
        this.rev_staf = rev_staf;
        this.rev_clean = rev_clean;
        this.rev_food = rev_food;
        this.rev_design = rev_design;
        this.comments = comments;
    }

    //setter and function
    public int setName() {
        System.out.println("Enter your name : ");
        String inputName = scanner.nextLine();//mohamed ayman
        while (inputName == null) {
            System.out.println("Incorrect Input\nRenter your name :  ");
            inputName = scanner.nextLine();
        }
        this.Name = inputName;
        return 0;
    }

    public void setNum_phone() {
        System.out.println("Enter your telephone number : ");
        String inputnum_phone = scanner.next();//01029494405
        while (inputnum_phone.length() != 11) {
            System.out.println("Incorrect Input\nRenter your telephone number : ");
            inputnum_phone = scanner.next();
        }
        this.num_phone = inputnum_phone;
    }

    public void setRev_rest() {
        System.out.println("How would you rate the restaurant out of 10? ");
        float inputrev_rest = scanner.nextFloat();//10
        while (inputrev_rest < 0 || inputrev_rest > 10) {
            System.out.println("Incorrect Input\nHow would you rate the restaurant out of 10? ");
            inputrev_rest = scanner.nextFloat();
        }
        this.rev_rest = inputrev_rest;
    }

    public void setRev_staf() {
        System.out.println("How much do you rate the staff out of 10? ");
        float inputrev_staff = scanner.nextFloat();//9.5
        while (inputrev_staff < 0 || inputrev_staff > 10) {
            System.out.println("Incorrect Input\nHow much do you rate the staff out of 10?");
            inputrev_staff = scanner.nextFloat();
        }
        this.rev_staf = inputrev_staff;
    }

    public void setRev_clean() {
        System.out.println("How would you rate the cleanliness of the restaurant out of 10?");
        float inputrev_clean = scanner.nextFloat();//5.5
        while (inputrev_clean < 0 || inputrev_clean > 10) {
            System.out.println("Incorrect Input\nHow would you rate the cleanliness of the restaurant out of 10? ");
            inputrev_clean = scanner.nextFloat();
        }
        this.rev_clean = inputrev_clean;
    }

    public void setRev_food() {
        System.out.println("How would you rate the food out of 10? ");
        float inputrev_food = scanner.nextFloat();//6.3
        while (inputrev_food < 0 || inputrev_food > 10) {
            System.out.println("Incorrect Input\nHow would you rate the food out of 10? ");
            inputrev_food = scanner.nextFloat();
        }
        this.rev_food = inputrev_food;
    }

    public void setRev_design() {
        System.out.println("How would you rate the restaurant design out of 10? ");
        float inputrev_design = scanner.nextFloat();//2.2
        while (inputrev_design < 0 || inputrev_design > 10) {
            System.out.println("Incorrect Input\nHow would you rate the restaurant design out of 10? ");
            inputrev_design = scanner.nextFloat();
        }
        this.rev_design = inputrev_design;
    }

    public void setComments() {
        System.out.println("Are there any additional comments true or false? ");
        String inputcomments = scanner.next();
        if (inputcomments.equals("t") == true || inputcomments.equals("T") == true || inputcomments.equals("true") == true || inputcomments.equals("True") == true || inputcomments.equals("TRUE") == true) {
            inputcomments = scanner.next();
            this.comments = inputcomments;
        }
        System.out.println("\nThank you for your vote and we look forward to seeing you soon :)");
    }

    //getter
    public String getName() {
        return Name;
    }

    public String getNum_phone() {
        return num_phone;
    }

    public float getRev_rest() {
        return rev_rest;
    }

    public float getRev_staf() {
        return rev_staf;
    }

    public float getRev_clean() {
        return rev_clean;
    }

    public float getRev_food() {
        return rev_food;
    }

    public float getRev_design() {
        return rev_design;
    }

    public String getComments() {
        return comments;
    }

    ////////////////////////////////////////

    public void saveToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.format("Name: %s%n", Name));
            writer.write(String.format("Phone Number: %s%n", num_phone));
            writer.write(String.format("Restaurant Rating: %.1f%n", rev_rest));
            writer.write(String.format("Staff Rating: %.1f%n", rev_staf));
            writer.write(String.format("Cleanliness Rating: %.1f%n", rev_clean));
            writer.write(String.format("Food Rating: %.1f%n", rev_food));
            writer.write(String.format("Design Rating: %.1f%n", rev_design));
            writer.write(String.format("Comments: %s%n", (comments != null ? comments : "N/A")));
            writer.write("-------------------------");
            writer.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

}
