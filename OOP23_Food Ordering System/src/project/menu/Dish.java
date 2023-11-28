package project.menu;

public class Dish {
    private String name;
    private String description;
    private double price;
    private String additionalOption;

    public Dish(String name, String description, double price, String additionalOption)
    {
        this.name = name;
        this.description = description;
        this.price = price;
        this.additionalOption=additionalOption;
    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getAdditionalOption() {
        return additionalOption;
    }

}