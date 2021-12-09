package wiloke.apidemo.myshopkit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import wiloke.apidemo.myshopkit.Models.UsersModel;

public interface UsersRepositories extends JpaRepository <UsersModel, Long> {
    UsersModel findByUsername(String username);
}
