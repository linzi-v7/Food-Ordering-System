package project.restaurant;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
    public String restaurantName;
    public String restaurantAddress;
    public String restaurantContact;
    public String restaurantEmail;
    public String restaurantPassword;

    ArrayList<ArrayList<String>> restaurants;

    public Restaurant() {
        this.restaurants = new ArrayList<>();

    }

    public ArrayList<ArrayList<String>> getRestaurants() {
        return restaurants;
    }

    public void loadRestaurantsFromFile(String filepath) {
        try {
            Scanner fileScanner = new Scanner(new File(filepath));

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

    public void addRestaurantDetails(String restaurantName, String restaurantContact, String restaurantAddress, String restaurantEmail, String restaurantPassword) {
        ArrayList<String> restaurantDetails = new ArrayList<>();
        restaurantDetails.add(restaurantName);
        restaurantDetails.add(restaurantContact);
        restaurantDetails.add(restaurantAddress);
        restaurantDetails.add(restaurantEmail);
        restaurantDetails.add(restaurantPassword);
        restaurants.add(restaurantDetails);

    }


    public  String login(Restaurant restaurant,String mail,String password) {

        boolean mailValidation, passwordValidation;
        mailValidation=restaurant.compareEmail(mail);
        passwordValidation=restaurant.comparePassword(password);
boolean sameAccount = verifyAccount(mail,password);
        if ((mailValidation) && (passwordValidation)&&(sameAccount)) {
            return mail;

        }
        else {
            System.out.println("please enter the correct details of your account");
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
        boolean comparePassword (String password) {
        boolean uniquePassword = false;
        for (ArrayList<String> row : restaurants) {

            if (row.size() >= 4 && row.get(4).equals(password)) {
                return true; // Found a match

            }

        }

        return uniquePassword;
    }
    public String restaurantSearching(Restaurant restaurant)
    {
        String search;
        int restaurantNumber=0;
        System.out.println("enter the name of the restaurant you're searching for:");
        Scanner scanner = new Scanner(System.in);
       search= scanner.nextLine();
        for(ArrayList<String> mail: restaurants){
            if(mail.toString().startsWith(search)) {
                System.out.println(restaurantNumber);
                System.out.println(mail);
                restaurantNumber++;
            }
        }
    return null;
    }
boolean verifyAccount(String mail,String password)
{
    int index = 0;
    for (ArrayList<String> restaurants2 :restaurants)
    {
        if (restaurants2.size()>=3 && restaurants2.get(3).equals(mail))
            index = restaurants2.indexOf(4);
    }
    for (ArrayList<String>restaurant3:restaurants) {
        if (restaurant3.size() >= 4 && restaurant3.get(4).equals(password))
            if (index == restaurant3.indexOf(4))
                return true;
    }
    return false;
}
}
