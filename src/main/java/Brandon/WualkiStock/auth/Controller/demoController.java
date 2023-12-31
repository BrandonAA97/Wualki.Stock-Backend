package Brandon.WualkiStock.auth.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth/admin")
@RequiredArgsConstructor
public class demoController {

    @GetMapping("/demo")
    public String welcome(){
        return "Welcome from secure endpoint";
    }
}
