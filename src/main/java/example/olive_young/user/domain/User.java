package example.olive_young.user.domain;

import example.olive_young.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String username;

    @Builder
    private User(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public static User create(String email, String password, String username) {
        return User.builder()
            .email(email)
            .password(password)
            .username(username)
            .build();
    }

}
