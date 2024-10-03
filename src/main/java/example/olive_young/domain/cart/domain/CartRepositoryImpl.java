package example.olive_young.domain.cart.domain;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CartRepositoryImpl implements CartRepository {

    private final CartSpringDataJpaRepository cartRepository;

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Cart findCardByUserId(Long userId) {
        return cartRepository.findByUserId(userId)
            .orElseThrow(() -> new EntityNotFoundException("장바구니를 조회할 수 없습니다."));
    }

}
