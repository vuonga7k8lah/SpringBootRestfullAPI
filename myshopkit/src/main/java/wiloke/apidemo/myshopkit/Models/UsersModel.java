package wiloke.apidemo.myshopkit.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class UsersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String username;
    private String token;
    private String password;
}
