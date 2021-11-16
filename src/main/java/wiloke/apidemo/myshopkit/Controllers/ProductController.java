package wiloke.apidemo.myshopkit.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wiloke.apidemo.myshopkit.Models.MessageFactory;
import wiloke.apidemo.myshopkit.Models.ProductModel;
import wiloke.apidemo.myshopkit.Repositories.ProductRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

//annotation định nghĩa 1 controller
@RestController
//định tuyến và routing cho nó đây,ánh xạ các request
@RequestMapping(path = "/api/v1/products")
public class ProductController {

    //DI: Dependency injection
    @Autowired
    private ProductRepository productRepository;

    //this request:http://localhost:8080/api/v1/products
    @GetMapping("")
    List<ProductModel> getAllProducts() {
        return productRepository.findAll();// get all
    }

    //get detail product
    @GetMapping("/{id}")
    ResponseEntity<MessageFactory> getProduct(@PathVariable Long id) {

        Optional<ProductModel> aProducts = productRepository.findById(id);

        return (aProducts.isPresent()) ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new MessageFactory("success", "List data", aProducts)
                ) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                        new MessageFactory("error", "sorry the product id is required", null)
                );
    }
    //insert product
    @PostMapping
    ResponseEntity<MessageFactory> createProduct(@RequestBody ProductModel aDataProduct) {

        //check product is exist product
        List <ProductModel> isProductExist=productRepository.findByProductName(aDataProduct.getProductName());

        return isProductExist.size() > 0
                ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new MessageFactory("error","Sorry, The product had existed",null)
        )
                :ResponseEntity.status(HttpStatus.OK).body(
                new MessageFactory("success","insert product ok",productRepository.save(aDataProduct))
        );
    }

    @PutMapping("/{id}")
    ResponseEntity <MessageFactory> updateProduct(@RequestBody ProductModel aDataProduct,@PathVariable Long id){

        Optional <ProductModel> updateProduct= productRepository.findById(id).map(
          productModel -> {
              productModel.setProductName(aDataProduct.getProductName());
              productModel.setPrice(aDataProduct.getPrice());
              productModel.setYear(aDataProduct.getYear());
              productModel.setUrl(aDataProduct.getUrl());

              return productRepository.save(productModel);
          }
        );
        return updateProduct.isEmpty()? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new MessageFactory("error","The product is not exist","")
        ): ResponseEntity.status(HttpStatus.OK).body(
                new MessageFactory("success","The product update successfully","")
        );

    }
    @DeleteMapping("/{id}")
    ResponseEntity <MessageFactory> deleteProduct(@PathVariable Long id){
        boolean existProduct=productRepository.existsById(id);
        if (existProduct){
            productRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
              new MessageFactory("success","The product delete successfully","")
            );
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new MessageFactory("error","The product not exist","")
            );
        }
    }
}
