package example.olive_young.domain.cart.api.controller;

import example.olive_young.domain.cart.api.controller.request.AddCartItemRequest;
import example.olive_young.domain.cart.api.service.CartService;
import example.olive_young.domain.cart.api.service.response.AddCartItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class CartController {

    private final CartService cartService;

    @PostMapping("/v1/cart")
    public AddCartItemResponse addItem(@RequestBody AddCartItemRequest request) {
        return cartService.addItem(request);
    }

}
