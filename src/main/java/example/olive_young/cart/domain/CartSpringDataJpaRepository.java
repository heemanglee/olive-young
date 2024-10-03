package example.olive_young.cart.domain;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartSpringDataJpaRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByUserId(Long userId);

}
