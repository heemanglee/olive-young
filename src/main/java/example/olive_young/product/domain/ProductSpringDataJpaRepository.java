package example.olive_young.product.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductSpringDataJpaRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByIdIn(List<Long> productIds);

    @Modifying(clearAutomatically = true)
    @Query("update Product p set p.promotion = :promotion where p.id in :productIds")
    void assignPromotion(@Param("promotion") Promotion promotion, List<Long> productIds);

    @Modifying(clearAutomatically = true)
    @Query("update Product p set p.promotion = null where p.promotion.id = :promotionId")
    void updatePromotionToNull(Long promotionId);

}
