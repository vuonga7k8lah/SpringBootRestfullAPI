package wiloke.apidemo.myshopkit.Models;

import javax.persistence.*;


@Entity
@Table(name = "tbl_blogs")
public class BlogModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String title;
    private String description;
    private String url_image;
    private String data;

    public BlogModel() {

    }

    @Override
    public String toString() {
        return "BlogModel{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url_image='" + url_image + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public BlogModel(Long id, String title, String description, String url_image, String data) {
        Id = id;
        this.title = title;
        this.description = description;
        this.url_image = url_image;
        this.data = data;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
