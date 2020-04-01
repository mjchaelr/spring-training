package tacos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import tacos.data.IngredientRepository;
import tacos.model.Ingredient;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome(){
        return "home";
    }

    @GetMapping("/test")
    public String getTest(){
        return "test";
    }

}
