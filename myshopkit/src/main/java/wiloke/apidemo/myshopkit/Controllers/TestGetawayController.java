package wiloke.apidemo.myshopkit.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestGetawayController {
    @GetMapping("/")
    public String getTest(){
        return"hello";
    }
}
