package project.review;

import java.util.Scanner;
public class review {
    private String Name = "null";
    private int num_phone = 0;
    private float rev_rest = 0;
    private float rev_staf = 0;
    private float rev_clean = 0;
    private float rev_food = 0;
    private float rev_design = 0;
    private String comments;
    private   Scanner scanner = new Scanner(System.in);

    //constructors
    public review(){
    }

    public review(String name , int num_phone){
        this.Name=name;
        this.num_phone=num_phone;
    }

    public review(String name , int num_phone , float rev_rest){
        this.Name=name;
        this.num_phone=num_phone;
        this.rev_rest=rev_rest;
    }

    public review(String name , int num_phone , float rev_rest , float rev_staf){
        this.Name=name;
        this.num_phone=num_phone;
        this.rev_rest=rev_rest;
        this.rev_staf=rev_staf;
    }

    public review(String name , int num_phone , float rev_rest , float rev_staf , float rev_clean){
        this.Name=name;
        this.num_phone=num_phone;
        this.rev_rest=rev_rest;
        this.rev_staf=rev_staf;
        this.rev_clean=rev_clean;
    }

    public review(String name , int num_phone , float rev_rest , float rev_staf , float rev_clean , float rev_food){
        this.Name=name;
        this.num_phone=num_phone;
        this.rev_rest=rev_rest;
        this.rev_staf=rev_staf;
        this.rev_clean=rev_clean;
        this.rev_food=rev_food;
    }

    public review(String name , int num_phone , float rev_rest , float rev_staf , float rev_clean , float rev_food , float rev_design){
        this.Name=name;
        this.num_phone=num_phone;
        this.rev_rest=rev_rest;
        this.rev_staf=rev_staf;
        this.rev_clean=rev_clean;
        this.rev_food=rev_food;
        this.rev_design=rev_design;
    }

    public review(String name , int num_phone , float rev_rest , float rev_staf , float rev_clean , float rev_food , float rev_design, String comments){
        this.Name=name;
        this.num_phone=num_phone;
        this.rev_rest=rev_rest;
        this.rev_staf=rev_staf;
        this.rev_clean=rev_clean;
        this.rev_food=rev_food;
        this.rev_design=rev_design;
        this.comments=comments;
    }

    //setter and function
    public void setName() {
        System.out.println("enter your name : ");
        String inputName = scanner.nextLine();//mohamed ayman
        while (inputName == null){
            System.out.println("\nerror");
            inputName = scanner.nextLine();
        }
        Name = inputName;
    }

    public void setNum_phone() {
        System.out.println("enter your telephone number : ");
        int inputnum_phone = scanner.nextInt();//01029494405
        while (inputnum_phone < 0){
            System.out.println("\nerror");
            inputnum_phone = scanner.nextInt();
        }
        this.num_phone = inputnum_phone;
    }

    public void setRev_rest() {
        System.out.println("How would you rate the restaurant out of 10? ");
        float inputrev_rest = scanner.nextFloat();//10
        while (inputrev_rest < 0 ){
            System.out.println("\nerror");
            inputrev_rest = scanner.nextFloat();
        }
        this.rev_rest = inputrev_rest;
    }

    public void setRev_staf() {
        System.out.println("How much do you rate the staff out of 10? ");
        float inputrev_staff = scanner.nextFloat();//9.5
        while (inputrev_staff < 0){
            System.out.println("\nerror");
            inputrev_staff = scanner.nextFloat();
        }
        this.rev_staf = inputrev_staff;
    }

    public void setRev_clean() {
        System.out.println("How would you rate the cleanliness of the restaurant out of 10?");
        float inputrev_clean = scanner.nextFloat();//5.5
        while (inputrev_clean < 0){
            System.out.println("\nerror");
            inputrev_clean = scanner.nextFloat();
        }
        this.rev_clean = inputrev_clean;
    }

    public void setRev_food() {
        System.out.println("How would you rate the food out of 10? ");
        float inputrev_food = scanner.nextFloat();//6.3
        while (inputrev_food < 0 ){
            System.out.println("\nerror");
            inputrev_food = scanner.nextFloat();
        }
        this.rev_food = inputrev_food;
    }

    public void setRev_design() {
        System.out.println("How would you rate the restaurant design out of 10? ");
        float inputrev_design = scanner.nextFloat();//2.2
        while (inputrev_design < 0 ){
            System.out.println("\nerror");
            inputrev_design = scanner.nextFloat();
        }
        this.rev_design = inputrev_design;
    }

    public void setComments() {
        System.out.println("Are there any additional comments true or false? ");
        String inputcomments = scanner.nextLine();
        if (inputcomments.equals("true") == true){
            inputcomments = scanner.nextLine();
            this.comments = inputcomments;
        }
        System.out.println("\nThank you for your vote and we look forward to seeing you soon :)");
    }

    //getter
    public String getName() {
        return Name;
    }
    public int getNum_phone() {
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
}