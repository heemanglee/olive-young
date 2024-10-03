package example.olive_young.orderproduct.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemSpringDataJpaRepository extends JpaRepository<OrderItem, Long> {

}
