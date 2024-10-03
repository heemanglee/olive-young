package example.olive_young.product.api.controller.request;

import example.olive_young.product.domain.Product;
import java.util.List;
import lombok.Getter;

@Getter
public class StartPromotionRequest {

    private List<Long> productIds;

}
