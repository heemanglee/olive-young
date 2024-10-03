package example.olive_young.cart.api.service.response;

import example.olive_young.cart.domain.Cart;
import example.olive_young.product.domain.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AddCartItemResponse {

    private Long cartId;
    private Long productId;

    @Builder
    private AddCartItemResponse(Long cartId, Long productId) {
        this.cartId = cartId;
        this.productId = productId;
    }

    public static AddCartItemResponse from(Cart cart, Product product) {
        return AddCartItemResponse.builder()
            .cartId(cart.getId())
            .productId(product.getId())
            .build();
    }

}
