public class restaurant {
  public String restaurant_name;
  public String restaurant_address;
  public String restaurant_contact;
  public String restaurant_ratings;

  public restaurant(String restaurant_name,String restaurant_address,String restaurant_contact,String restaurant_ratings)
    {
this.restaurant_name=restaurant_name;
this.restaurant_address=restaurant_address;
this.restaurant_contact=restaurant_contact;
this.restaurant_ratings=restaurant_ratings;
    }
    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public void setRestaurant_address(String restaurant_address) {
        this.restaurant_address = restaurant_address;
    }

    public void setRestaurant_contact(String restaurant_contact) {
        this.restaurant_contact = restaurant_contact;
    }

    public void setRestaurant_ratings(String restaurant_ratings) {
        this.restaurant_ratings = restaurant_ratings;
    }
    public String getRestaurant_name() {
        return restaurant_name;
    }
    public String getRestaurant_address() {
        return restaurant_address;
    }

    public String getRestaurant_contact() {
        return restaurant_contact;
    }

    public String getRestaurant_ratings() {
        return restaurant_ratings;
    }

}
