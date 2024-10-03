package example.olive_young.product.api.controller.request;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class ProductRequest {

    private String productName;
    private LocalDateTime saleStartDate;
    private LocalDateTime saleEndDate;

}
