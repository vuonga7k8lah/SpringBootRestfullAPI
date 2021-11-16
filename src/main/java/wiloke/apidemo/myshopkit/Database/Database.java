package wiloke.apidemo.myshopkit.Database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.CommandLinePropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import wiloke.apidemo.myshopkit.Models.ProductModel;
import wiloke.apidemo.myshopkit.Repositories.ProductRepository;

@Configuration
public class Database {

    //Logger
    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    //    @Bean
//    CommandLineRunner initDatabase(ProductRepository productRepository){
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
////                ProductModel product1= new ProductModel("abc",2020,2400.3,"");
////                ProductModel product2= new ProductModel("cba",2021,2402.3,"");
////
////                logger.info("insert ok "+ productRepository.save(product1));
////                logger.info("insert ok "+ productRepository.save(product2));
//            }
//        };
//    }


}
