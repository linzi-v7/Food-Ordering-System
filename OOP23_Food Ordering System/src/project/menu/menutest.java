package project.menu;

public class menutest
{
    public static void main(String[] args) {
        Menu menus = new Menu();
        menus.readMenuDataFile();
        menus.addItem("mac", "burger triple", "30");
        menus.displayMenu("mac");

        menus.writeMenuDataFile();
    }
}
