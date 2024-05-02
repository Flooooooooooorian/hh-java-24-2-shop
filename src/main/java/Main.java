import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Product p1 = new Product("1", "Apple");

        Order o1 = new Order("1", List.of(p1), OrderStatus.NEW);
        Order o2 = new Order("2", List.of(p1), OrderStatus.NEW);
        Order o3 = new Order("3", List.of(p1), OrderStatus.COMPLETED);

        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);

        System.out.println(OrderStatus.IN_DELIVERY.ordinal());

        if (o1.status().equals(OrderStatus.NEW)) {
            System.out.println("gleicher status");
        }

        System.out.println("----------------------");


        OrderRepo orderRepo = new OrderMapRepo();

        orderRepo.addOrder(o1);

        System.out.println(orderRepo.getOrders());

        System.out.println(orderRepo.getOrderById("1").status());

        Order o4 = orderRepo.getOrderById("-1");

        if (o4 == null) {
            System.out.println("Bestellung wurde nicht gefunden");
        }
        else {
            System.out.println(o4.status());
        }


        Optional<Order> optionalOrder = Optional.of(o1);

        if (optionalOrder.isEmpty()) {
            System.out.println("isEmpty");
            return;
        }

        Order o5 = optionalOrder.orElseThrow();



    }
}
