package example.olive_young.domain.cartproduct.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartItemSpringDataJpaRepository extends JpaRepository<CartItem, Long> {

    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM CartItem ci WHERE ci.cart.id = (SELECT c.id FROM Cart c WHERE c.user.id = :userId) AND ci.product.id IN :productIds")
    void deleteProductFromCart(@Param("userId") Long userId, @Param("productIds") List<Long> productIds);

}
