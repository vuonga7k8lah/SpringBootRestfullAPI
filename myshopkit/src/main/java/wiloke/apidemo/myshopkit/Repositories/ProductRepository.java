package wiloke.apidemo.myshopkit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wiloke.apidemo.myshopkit.Models.ProductModel;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    List<ProductModel> findByProductName(String productName);

}
