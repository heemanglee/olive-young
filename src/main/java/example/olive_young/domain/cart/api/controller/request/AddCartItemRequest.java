package example.olive_young.domain.cart.api.controller.request;

import lombok.Getter;

@Getter
public class AddCartItemRequest {

    private Long productId;
    private Long userId;

}
