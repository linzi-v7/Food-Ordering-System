package project.menu;

public class menutest
{
    public static void main(String[] args) {
        Menu menus = new Menu();
        menus.readMenuDataFile("bk");
        menus.addItem("bk", "burger triple", 30.0);
        menus.displayMenu("bk");
        menus.writeMenuDataFile();
    }
}
