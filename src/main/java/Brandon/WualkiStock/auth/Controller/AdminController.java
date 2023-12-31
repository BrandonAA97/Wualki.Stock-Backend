package Brandon.WualkiStock.auth.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    //testing
    @GetMapping("/test")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String welcome(){
        return "Q onda??";
    }
}
