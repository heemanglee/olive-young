package example.olive_young.domain.user.domain;

public interface UserRepository  {

    User save(User user);

    User findById(Long userId);

}
