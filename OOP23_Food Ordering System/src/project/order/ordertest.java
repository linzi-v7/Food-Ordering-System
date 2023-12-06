package project.order;

import java.util.ArrayList;
import java.util.List;

public class ordertest
{
    public static void main(String[] args) {
        Order order = new Order("faris");

        List<String> items = new ArrayList<>();

        items.add("burger");
        items.add("fries");

        order.viewOrder();

        order.placeOrder(order.getUsername(), items);
        //order.viewOrders();
    }
}
