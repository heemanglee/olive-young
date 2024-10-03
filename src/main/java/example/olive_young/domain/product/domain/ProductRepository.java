package example.olive_young.domain.product.domain;

import java.util.List;

public interface ProductRepository {

    Product save(Product product);

    List<Product> findAllByIdIn(List<Long> productIds);

    Product findById(Long productId);

    void assignPromotion(Promotion promotion, List<Long> productIds);

    void updatePromotionToNull(Long promotionId);

}
