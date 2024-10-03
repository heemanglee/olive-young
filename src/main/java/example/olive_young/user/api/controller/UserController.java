package example.olive_young.user.api.controller;

import example.olive_young.user.api.controller.request.SignUpRequest;
import example.olive_young.user.api.service.response.SignUpResponse;
import example.olive_young.user.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/v1/user")
    public SignUpResponse signUp(@RequestBody SignUpRequest request)  {
        return userService.signUp(request);
    }

}
