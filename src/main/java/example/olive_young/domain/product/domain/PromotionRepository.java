package example.olive_young.domain.product.domain;

public interface PromotionRepository {

    Promotion save(Promotion promotion);

    Promotion findById(Long promotionId);

    void deleteBy(Long promotionId);

}
