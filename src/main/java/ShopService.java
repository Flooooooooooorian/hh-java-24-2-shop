import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ShopService {
    private ProductRepo productRepo = new ProductRepo();
    private OrderRepo orderRepo = new OrderMapRepo();

    public Order addOrder(List<String> productIds) {
        List<Product> products = new ArrayList<>();
        for (String productId : productIds) {
            Optional<Product> optionalProduct = productRepo.getProductById(productId);
            if (optionalProduct.isEmpty()) {
                System.out.println("Product mit der Id: " + productId + " konnte nicht bestellt werden!");
                return null;
            }
            products.add(optionalProduct.get());
        }

        Order newOrder = new Order(UUID.randomUUID().toString(), products, OrderStatus.NEW);

        return orderRepo.addOrder(newOrder);
    }
}
