package example.olive_young.domain.user.api.service.response;

import example.olive_young.domain.cart.domain.Cart;
import example.olive_young.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SignUpResponse {

    private Long userId;
    private String email;
    private String password;
    private String username;

    private Long cartId;

    @Builder
    private SignUpResponse(Long userId, String email, String password, String username, Long cartId) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.username = username;
        this.cartId = cartId;
    }

    public static SignUpResponse of(User user, Cart cart) {
        return SignUpResponse.builder()
            .userId(user.getId())
            .email(user.getEmail())
            .password(user.getPassword())
            .username(user.getUsername())
            .cartId(cart.getId())
            .build();
    }

}
