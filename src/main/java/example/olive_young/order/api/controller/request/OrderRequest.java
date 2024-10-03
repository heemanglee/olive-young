package example.olive_young.order.api.controller.request;

import java.util.List;
import lombok.Getter;

@Getter
public class OrderRequest {

    private Long userId;
    private List<Long> productIds;

}
