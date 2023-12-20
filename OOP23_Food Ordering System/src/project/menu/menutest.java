package project.menu;

public class menutest
{
    public static void main(String[] args) {
        Menu menus = new Menu();
        menus.readMenuDataFile("nader");
        menus.addNewDish("nader", "burger triple", 30.0);
        menus.displayMenu("nader");
        menus.writeMenuDataFile();
    }
}
