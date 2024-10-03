package example.olive_young.domain.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSpringDataJpaRepository extends JpaRepository<User, Long> {

}
