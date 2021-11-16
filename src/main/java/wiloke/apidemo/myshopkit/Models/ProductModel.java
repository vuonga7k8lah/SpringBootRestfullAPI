package wiloke.apidemo.myshopkit.Models;

import javax.persistence.*;

//POJO = plain Object Java Object
@Entity
@Table(name = "test")
public class ProductModel {
    @Id//khoá chính
    @GeneratedValue(strategy = GenerationType.IDENTITY)//tự sinh
    private Long id;
    @Column(name = "productName",nullable = false,unique = true,length = 300)
    private String productName;
    private int year;
    private Double price;
    private String url;


    public ProductModel( String productName, int year, Double price, String url) {
        this.productName = productName;
        this.year = year;
        this.price = price;
        this.url = url;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getYear() {
        return year;
    }

    public Double getPrice() {
        return price;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", url='" + url + '\'' +
                '}';
    }

    //default constructor
    public ProductModel(){

    }
}
