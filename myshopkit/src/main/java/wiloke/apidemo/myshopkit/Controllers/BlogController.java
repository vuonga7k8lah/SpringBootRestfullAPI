package wiloke.apidemo.myshopkit.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wiloke.apidemo.myshopkit.Models.BlogModel;
import wiloke.apidemo.myshopkit.Models.DeleteRequest;
import wiloke.apidemo.myshopkit.Models.MessageFactory;
import wiloke.apidemo.myshopkit.Repositories.BlogRepositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/blogs")
public class BlogController {
    @Autowired
    private BlogRepositories BlogRepositories;

    public BlogController() {

    }
    //API test getaway

    //API get all
    @GetMapping
    ResponseEntity<MessageFactory> getAllBlogs() {
        List<BlogModel> aBlogs = BlogRepositories.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(
                new MessageFactory("success", "list blogs", aBlogs)
        );
    }

    //API get one
    @GetMapping(path = "/{id}")
    ResponseEntity<MessageFactory> getBlog(@PathVariable Long id) {
        Optional<BlogModel> isBlogExit = BlogRepositories.findById(id);
        return isBlogExit.isEmpty() ? ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new MessageFactory("error", "The blog id is not exist", "")
        ) : ResponseEntity.status(HttpStatus.OK).body(
                new MessageFactory("success", "list data", isBlogExit)
        );
    }

    //API post
    @PostMapping
    ResponseEntity<MessageFactory> createBlogs(@RequestBody BlogModel aDataBlog) {
        List<BlogModel> isBlogExist = BlogRepositories.findBlogModelByTitle(aDataBlog.getTitle());

        if (isBlogExist.size() == 0) {

            BlogRepositories.save(aDataBlog);

            return ResponseEntity.status(HttpStatus.OK).body(
                    new MessageFactory("success", "insert blogs ok", "")
            );
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new MessageFactory("error", "The Blog is exist", "")
        );

    }
    //API PUT

    @PutMapping(path = "/{id}")
    ResponseEntity<MessageFactory> updateBlogs(@RequestBody BlogModel aDataBlog, @PathVariable Long id) {
        Optional<BlogModel> isBlogExist = BlogRepositories.findById(id);
        if (isBlogExist.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new MessageFactory("error", "The Blogs id is not exist", "")
            );
        }
        isBlogExist.map(
                blogModel -> {
                    blogModel.setTitle(aDataBlog.getTitle());
                    blogModel.setData(aDataBlog.getData());
                    blogModel.setDescription(aDataBlog.getDescription());
                    blogModel.setUrl_image(aDataBlog.getUrl_image());
                    return BlogRepositories.save(blogModel);
                }
        );
        return ResponseEntity.status(HttpStatus.OK).body(
                new MessageFactory("success", "The Blogs update successfully", "")
        );
    }

    //API one DELETE
    @DeleteMapping(path = "/{id}")
    ResponseEntity<MessageFactory> deleteBlog(@PathVariable Long id) {
        Optional<BlogModel> isBlogExist = BlogRepositories.findById(id);
        if (isBlogExist.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    new MessageFactory("error","Sorry the blogs not exist","")
            );
        }
        BlogRepositories.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new MessageFactory("success","the blogs deleted blogs successfully","")
        );
    }

    //API Delete multi
    @DeleteMapping
    ResponseEntity <MessageFactory> deleteBlogs(@RequestBody DeleteRequest aData){
        String[] aIds = aData.getIds().split(",");
        for (String blogID: aIds) {
            Long id = Long.parseLong(blogID);
            Optional<BlogModel> isBlogExist = BlogRepositories.findById(id);
            if (isBlogExist.isPresent()){
                BlogRepositories.deleteById(id);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new MessageFactory("success","xx",aIds)
        );
    }
}
