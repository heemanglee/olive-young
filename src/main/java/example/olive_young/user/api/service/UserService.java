package example.olive_young.user.api.service;

import example.olive_young.cart.domain.Cart;
import example.olive_young.cart.domain.CartRepository;
import example.olive_young.cartproduct.domain.CartItemRepository;
import example.olive_young.user.api.controller.request.SignUpRequest;
import example.olive_young.user.api.service.response.SignUpResponse;
import example.olive_young.user.domain.User;
import example.olive_young.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final CartRepository cartRepository;

    @Transactional
    public SignUpResponse signUp(SignUpRequest request) {
        User user = createUser(request);
        userRepository.save(user);
        Cart cart = Cart.create(user);
        cartRepository.save(cart);
        return SignUpResponse.of(user, cart);
    }

    private static User createUser(SignUpRequest request) {
        return User.create(request.getEmail(), request.getPassword(), request.getUsername());
    }

}
