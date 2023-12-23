package project.restaurant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Restaurant implements RestaurantPermissions{
    protected String restaurantName;
    protected String restaurantAddress;
    protected String restaurantContact;
    protected String restaurantEmail;
    protected String restaurantPassword;

    ArrayList<ArrayList<String>> restaurants;

    public Restaurant() {
        this.restaurants = new ArrayList<>();

    }

    public Restaurant(String restaurantName)
    {
        this.restaurants = new ArrayList<>();
        this.restaurantName = restaurantName;
    }

    public Restaurant(String restaurantName, String restaurantAddress, String restaurantContact, String restaurantEmail, String restaurantPassword) {
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantContact = restaurantContact;
        this.restaurantEmail = restaurantEmail;
        this.restaurantPassword = restaurantPassword;
        this.restaurants = new ArrayList<>();
    }

    public ArrayList<ArrayList<String>> getRestaurants() {
        return restaurants;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public String getRestaurantContact() {
        return restaurantContact;
    }

    public String getRestaurantEmail() {
        return restaurantEmail;
    }

    public String getRestaurantPassword() {
        return restaurantPassword;
    }

    public void loadRestaurantsFromFile() {
        try {
            Scanner fileScanner = new Scanner(new File("restaurants.txt"));

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String restaurantName = parts[0].trim();
                    String restaurantContact = parts[1].trim();
                    String restaurantAddress = parts[2].trim();
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

    public void RestaurantSaveToFiles(ArrayList<ArrayList<String>> restaurants) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("restaurants.txt"))) {
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

    public void addRestaurantDetails(String restaurantName, String restaurantContact, String restaurantAddress, String restaurantEmail, String restaurantPassword) {
        ArrayList<String> restaurantDetails = new ArrayList<>();
        restaurantDetails.add(restaurantName);
        restaurantDetails.add(restaurantContact);
        restaurantDetails.add(restaurantAddress);
        restaurantDetails.add(restaurantEmail);
        restaurantDetails.add(restaurantPassword);
        restaurants.add(restaurantDetails);

    }


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

    boolean compareEmail(String email) {
        boolean uniqueEmail = false;
        for (ArrayList<String> row : restaurants) {

            if (row.size() >= 3 && row.get(3).equals(email)) {

                return true; // Found a match

            }

        }
        return uniqueEmail;
    }

    boolean comparePassword(String password) {
        boolean uniquePassword = false;
        for (ArrayList<String> row : restaurants) {

            if (row.size() >= 4 && row.get(4).equals(password)) {
                return true; // Found a match

            }

        }

        return uniquePassword;
    }

    public void restaurantSearching(Restaurant restaurant) {

        int counter = 0;
        System.out.println("enter the name of the restaurant you're searching for:");
        Scanner scanner = new Scanner(System.in);
        String search = scanner.nextLine();
        for (ArrayList<String> restaurant1 : restaurant.restaurants) {
            if (restaurant1.get(0).startsWith(search)) {
                counter++;
                System.out.println(counter + "." + restaurant1.get(0));
            }
        }

    }

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

    public ArrayList<String> getRestaurantEmail(String mail)
    {
        ArrayList<String> restaurant = new ArrayList<>();



        for (ArrayList<String> restaurants2 : restaurants) {
            if (restaurants2.size() >= 3 && restaurants2.get(3).equals(mail))
            {



                String name = restaurants2.get(0);
                String phoneNumber = restaurants2.get(1);
                String address = restaurants2.get(2);
                String email = restaurants2.get(3);
                String password = restaurants2.get(4);
                return restaurants2;
            }
        }
        return null;

    }
}
