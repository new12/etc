package lky.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2015/9/2.
 */
@Controller
public class WelcomeController {
    @RequestMapping(value="/welcome")
    public String welcome(){
        return  "welcome";
    }
}
