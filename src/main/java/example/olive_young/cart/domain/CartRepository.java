package example.olive_young.cart.domain;

public interface CartRepository {

    Cart save(Cart cart);

    Cart findCardByUserId(Long userId);

}
