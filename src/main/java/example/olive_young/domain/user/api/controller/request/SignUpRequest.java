package example.olive_young.domain.user.api.controller.request;

import lombok.Getter;

@Getter
public class SignUpRequest {

    private String email;
    private String password;
    private String username;

}
