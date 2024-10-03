package example.olive_young.order.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderSpringDataJpaRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

}
