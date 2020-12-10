package phone.check.task.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {
	@RequestMapping("/")
    public String homepage(){
        return "index";
    }
}
