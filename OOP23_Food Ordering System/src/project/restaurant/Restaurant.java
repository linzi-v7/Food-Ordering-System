package project.restaurant;

public class Restaurant {
  public String restaurantName;
  public String restaurantAddress;
  public String restaurantContact;
  public String restaurantRatings;

  public Restaurant(String restaurantName, String restaurantAddress, String restaurantContact, String restaurantRatings)
    {
this.restaurantName =restaurantName;
this.restaurantAddress =restaurantAddress;
this.restaurantContact =restaurantContact;
this.restaurantRatings =restaurantRatings;
    }
    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public void setRestaurantContact(String restaurantContact) {
        this.restaurantContact = restaurantContact;
    }

    public void setRestaurantRatings(String restaurantRatings) {
        this.restaurantRatings = restaurantRatings;
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

    public String getRestaurantRatings() {
        return restaurantRatings;
    }

}
