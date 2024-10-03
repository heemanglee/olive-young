package example.olive_young.user.domain;

public interface UserRepository  {

    User save(User user);

    User findById(Long userId);

}
