package project.restaurant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
@SuppressWarnings("SuspiciousMethodCalls")
public class  Restaurant {
    protected String restaurantName;
    protected String restaurantAddress;
    protected String restaurantContact;
    protected String restaurantEmail;
    protected String restaurantPassword;

    ArrayList<ArrayList<String>> restaurants;

    public Restaurant() {
        this.restaurants = new ArrayList<>();

    }

    public ArrayList<ArrayList<String>> getRestaurants() {
        return restaurants;
    }

    /**
     * function used to load the restaurants from the file
     */
    public void loadRestaurantsFromFile() {
        try {
            Scanner fileScanner = new Scanner(new File("\"C:\\Users\\Omar Fakharany\\IdeaProjects\\restaurant\\restaurants.txt\""));

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String restaurantName = parts[0].trim();
                    String restaurantAddress = parts[1].trim();
                    String restaurantContact = parts[2].trim();
                    String restaurantEmail = parts[3].trim();
                    String restaurantPassword = parts[4].trim();
                    addRestaurantDetails(restaurantName, restaurantContact, restaurantAddress, restaurantEmail, restaurantPassword);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing price: " + e.getMessage());
        }

    }

    /** function used to save restaurants to the files
     *
     * @param restaurants the restaurants and all the details
     */
    public void RestaurantSaveToFiles(ArrayList<ArrayList<String>> restaurants) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("\"C:\\Users\\Omar Fakharany\\IdeaProjects\\restaurant\\restaurants.txt\""))) {
            for (ArrayList<String> row : restaurants) {
                // Join elements of the row into a single string, separated by commas
                String line = String.join(",", row);
                // Write the line to the file
                writer.write(line);
                // Write a newline character to separate rows
                writer.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /** function gets the details of the restaurant and add it to the restaurant arraylist
     * it has no returns
     *
     * @param restaurantName the name of the restaurant
     * @param restaurantContact the phone number of the restaurant
     * @param restaurantAddress the address of the restaurant
     * @param restaurantEmail the mail of the restaurant
     * @param restaurantPassword the password of the restaurant
     */
    public void addRestaurantDetails(String restaurantName, String restaurantContact, String restaurantAddress, String restaurantEmail, String restaurantPassword) {
        ArrayList<String> restaurantDetails = new ArrayList<>();
        restaurantDetails.add(restaurantName);
        restaurantDetails.add(restaurantContact);
        restaurantDetails.add(restaurantAddress);
        restaurantDetails.add(restaurantEmail);
        restaurantDetails.add(restaurantPassword);
        restaurants.add(restaurantDetails);

    }

    /** function gets mail and password and calls 3 functions to confirm that
     *  mail and password exists and from the same account then returns the mail if true else returns null
     *
     * @param restaurant the restaurant object used to access the restaurant arraylist
     * @param mail the mail entered by the restaurant
     * @param password the password of the restaurant
     * @return the mail of the restaurant if true else returns null
     */
    public String login(Restaurant restaurant, String mail, String password) {

        boolean mailValidation, passwordValidation;
        mailValidation = restaurant.compareEmail(mail);
        passwordValidation = restaurant.comparePassword(password);
        boolean sameAccount = verifyAccount(mail, password);
        if ((mailValidation) && (passwordValidation) && (sameAccount)) {
            return mail;

        }

        return "null";
    }

    /**when called this function gets the email entered and compare the email
     * to the elements inside the 3rd row in the arraylist and if a match is found then it
     * returns true if a match is found and false if no match is found
     *
     * @param email the email the user entered being compared to
     * @return true if the restaurant email is unique and false if not
     */
    boolean compareEmail(String email) {
        boolean uniqueEmail = false;
        for (ArrayList<String> row : restaurants) {

            if (row.size() >= 3 && row.get(3).equals(email)) {

                return true; // Found a match

            }

        }
        return uniqueEmail;
    }

    /** when called this function gets the password entered and compare the password
     * to the elements inside the 4'th row in the arraylist and if a match is found then it
     * returns true if a match is found and false if no match is found
     *
     * @param password the password the user entered being compared to
     * @return true if the restaurant password is unique and false if not
     */
    boolean comparePassword(String password) {
        boolean uniquePassword = false;
        for (ArrayList<String> row : restaurants) {

            if (row.size() >= 4 && row.get(4).equals(password)) {
                return true; // Found a match

            }

        }

        return uniquePassword;
    }

    /** this function is used to search for a specific restaurant
     * when the function is called it asks the user to enter the name of the restaurant it's searching for and
     * compare the input with the name elements inside the arraylist and when a match is found
     * it displays the name found
     *
     * @param restaurant the restaurant object that was made
     */
    public ArrayList restaurantSearching(Restaurant restaurant) {

        int counter=0;
                ArrayList<Integer> countedValues= new ArrayList<>();
        System.out.println("enter the name of the restaurant you're searching for:");
        Scanner scanner = new Scanner(System.in);
        String search = scanner.nextLine();
        for (ArrayList<String> restaurant1 : restaurant.restaurants) {
            counter++;
            if (restaurant1.get(0).startsWith(search)) {

                System.out.println(counter + "." + restaurant1.get(0));
                countedValues.add(counter);
            }
        }
return countedValues;
    }

    /**
     * this function gets the mail and the password entered by the user and checks that they're from same account
     * by making sure the row is the same and then returns the result
     * @param mail mail entered from the user
     * @param password password entered from the user
     * @return if they're the same return true else return false
     */
    private boolean verifyAccount(String mail, String password) {
        int index = 0;
        for (ArrayList<String> restaurants2 : restaurants) {
            if (restaurants2.size() >= 3 && restaurants2.get(3).equals(mail))
                index = restaurants2.indexOf(4);
        }
        for (ArrayList<String> restaurant3 : restaurants) {
            if (restaurant3.size() >= 4 && restaurant3.get(4).equals(password))
                if (index == restaurant3.indexOf(4))
                    return true;
        }
        return false;
    }

    /**
     * this function return the details of the restaurant after getting the mail
     * of the logged in restaurant,it does that after accessing the arraylist
     * restaurant and comparing the current mail
     * with all the mails and when a match is found it return's all the details
     * @param mail mail of the restaurant
     *
     * @return  restaurants2 that contains restaurant's: name,phone,mail,address,password
     */
    public ArrayList<String> getRestaurantEmail(String mail)
    {
        for (ArrayList<String> restaurants2 : restaurants) {
            if (restaurants2.size() >= 3 && restaurants2.get(3).equals(mail))
            {
           return restaurants2;
            }
        }
            return null;

    }
}
