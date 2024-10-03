package example.olive_young.product.api.service.response;

import example.olive_young.product.domain.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductResponse {

    private Long productId;
    private String productName;
    private String saleStartDate;
    private String saleEndDate;

    @Builder
    private ProductResponse(Long productId, String productName, String saleStartDate,
        String saleEndDate) {
        this.productId = productId;
        this.productName = productName;
        this.saleStartDate = saleStartDate;
        this.saleEndDate = saleEndDate;
    }

    public static ProductResponse from(Product product) {
        return ProductResponse.builder()
            .productId(product.getId())
            .productName(product.getName())
            .saleStartDate(String.valueOf(product.getSaleStartDate()))
            .saleEndDate(String.valueOf(product.getSaleEndDate()))
            .build();
    }

}
