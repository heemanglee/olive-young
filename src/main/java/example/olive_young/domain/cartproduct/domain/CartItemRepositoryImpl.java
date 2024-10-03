package example.olive_young.domain.cartproduct.domain;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CartItemRepositoryImpl implements CartItemRepository {

    private final CartItemSpringDataJpaRepository cartItemRepository;

    @Override
    public void removeProductsFromCart(Long userId, List<Long> productIds) {
        cartItemRepository.deleteProductFromCart(userId, productIds);
    }

    @Override
    public CartItem save(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

}
