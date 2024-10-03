package example.olive_young.domain.product.api.controller.request;

import java.util.List;
import lombok.Getter;

@Getter
public class StartPromotionRequest {

    private List<Long> productIds;

}
