package example.olive_young.product.domain;

public interface PromotionRepository {

    Promotion save(Promotion promotion);

    Promotion findById(Long promotionId);

    void deleteBy(Long promotionId);

}
