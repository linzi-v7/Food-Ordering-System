package project.restaurant;
import project.menu.Menu;
import project.order.Order;
import java.util.Random;
import java.util.Scanner;


public interface RestaurantPermissions {
    default void addDishToMenuPage(Restaurant restaurant) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t### Restaurant Add Dish To Menu Page ###\n");

        menu.readMenuDataFile(restaurant.getRestaurantName());

        System.out.print("Enter Dish Name: ");
        String dishName = scanner.nextLine();

        System.out.print("Enter Dish Price: ");
        Double dishPrice = Double.parseDouble(scanner.nextLine());

        menu.addNewDish(restaurant.getRestaurantName(), dishName, dishPrice);
        menu.writeMenuDataFile();
    }


    default void viewOrders() {
        Order order = new Order("name");
        order.viewOrders();
    }


    //view profit,etc...
    default void generateBusinessReport(Restaurant restaurant) {
        Random rand = new Random();
        System.out.println("\t\t#### BUSINESS REPORT ####");
        System.out.println("Business Report For " + restaurant.getRestaurantName());
        System.out.println("Users served: " + rand.nextInt(5000));
        System.out.println("Revenue for the day: " + rand.nextInt(10000) + "$");
        System.out.println("Restaurant Performance: GREAT");
    }

}
