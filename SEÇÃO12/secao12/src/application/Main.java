package application;

import java.util.Date;
import entities.Order;
import entitiesenums.OrderStatus;

public class Main {

    public static void main(String[] args) {

        Order order = new Order(1, new Date(), OrderStatus.DELIVERED);
        System.out.println(order.toString());
    }
    
}
