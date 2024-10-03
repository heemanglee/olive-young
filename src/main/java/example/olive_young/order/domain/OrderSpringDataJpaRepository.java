package example.olive_young.order.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderSpringDataJpaRepository extends JpaRepository<Order, Long> {

}
