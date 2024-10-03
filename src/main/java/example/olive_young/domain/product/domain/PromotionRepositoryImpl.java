package example.olive_young.domain.product.domain;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class PromotionRepositoryImpl implements PromotionRepository {

    private final PromotionSpringDataJpaRepository promotionRepository;

    @Override
    public Promotion save(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    @Override
    public Promotion findById(Long promotionId) {
        return promotionRepository.findById(promotionId)
            .orElseThrow(() -> new EntityNotFoundException("프로모션 정보가 조회되지 않습니다."));
    }

    @Override
    public void deleteBy(Long promotionId) {
        promotionRepository.deleteById(promotionId);
    }
}
