package example.olive_young.product.api.service.response;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PromotionStatus {

    private Long promotionId;
    private List<ProductResponse> products;

    @Builder
    private PromotionStatus(Long promotionId, List<ProductResponse> products) {
        this.promotionId = promotionId;
        this.products = products;
    }

    public static PromotionStatus from(Long promotionId, List<ProductResponse> products) {
        return PromotionStatus.builder()
            .promotionId(promotionId)
            .products(products)
            .build();
    }

}
