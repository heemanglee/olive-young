package example.olive_young.orderproduct.domain;

import java.util.List;

public interface OrderItemRepository {

    void saveAll(List<OrderItem> orderItems);

}
