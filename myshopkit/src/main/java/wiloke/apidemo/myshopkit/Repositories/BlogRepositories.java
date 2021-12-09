package wiloke.apidemo.myshopkit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import wiloke.apidemo.myshopkit.Models.BlogModel;

import java.util.List;


public interface BlogRepositories extends JpaRepository<BlogModel, Long> {
    List <BlogModel> findBlogModelByTitle(String title);
}
