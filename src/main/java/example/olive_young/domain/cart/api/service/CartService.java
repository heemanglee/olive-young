package example.olive_young.domain.cart.api.service;

import example.olive_young.domain.cart.api.controller.request.AddCartItemRequest;
import example.olive_young.domain.cart.api.service.response.AddCartItemResponse;
import example.olive_young.domain.cart.domain.Cart;
import example.olive_young.domain.cart.domain.CartRepository;
import example.olive_young.domain.cartproduct.domain.CartItem;
import example.olive_young.domain.cartproduct.domain.CartItemRepository;
import example.olive_young.domain.product.domain.Product;
import example.olive_young.domain.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;

    @Transactional
    public AddCartItemResponse addItem(AddCartItemRequest request) {
        Cart cart = findCartBy(request.getUserId());
        Product product = findProductBy(request.getProductId());

        CartItem cartItem = CartItem.addProduct(cart, product);
        cartItemRepository.save(cartItem);
        return AddCartItemResponse.from(cart, product);
    }

    private Product findProductBy(Long productId) {
        return productRepository.findById(productId);
    }

    private Cart findCartBy(Long userId) {
        return cartRepository.findCardByUserId(userId);
    }

}
