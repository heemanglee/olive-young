package example.olive_young.product.domain;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductSpringDataJpaRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAllByIdIn(List<Long> productIds) {
        return productRepository.findAllByIdIn(productIds);
    }

    @Override
    public Product findById(Long productId) {
        return productRepository.findById(productId)
            .orElseThrow(() -> new EntityNotFoundException("상품을 조회할 수 없습니다."));
    }

    @Override
    public void updatePromotionToNull(Long promotionId) {
        productRepository.updatePromotionToNull(promotionId);
    }

    @Override
    public void assignPromotion(Promotion promotion, List<Long> productIds) {
        productRepository.assignPromotion(promotion, productIds);
    }

}
