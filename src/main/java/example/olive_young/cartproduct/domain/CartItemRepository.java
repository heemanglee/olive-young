package example.olive_young.cartproduct.domain;

import java.util.List;

public interface CartItemRepository {

    void removeProductsFromCart(Long userId, List<Long> productIds);

    CartItem save(CartItem cartItem);

}
