package nlu.nhcnpm.nhom8.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String email;
    String phoneNumber;
    String password;
    String avatar;
    String role;
    Calendar datePost;
    Calendar dateModified;
    int parent;
    String status;
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    List<Order> orders ;

    // for sign up
    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.parent = 0;
        this.role = role;
    }

}
