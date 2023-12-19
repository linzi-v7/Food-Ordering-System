package project.menu;

public class menutest
{
    public static void main(String[] args) {
        Menu menus = new Menu();
        menus.readRestaurantDataFile();

        menus.displayMenu("mac");
    }
}
