package kr.ac.jejunu.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/join")
    public String join(User user){
        userRepository.save(user);
        return "index";
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "/login";
    }
    @PostMapping("/login")
    public String login(String userId, String password, HttpSession session){
        User user= userRepository.findByUserId(userId);

        if(user==null){
            return "redirect:/users/loginForm";
        }
        if(!password.equals(user.getPassword())){
            return "redirect:/users/loginForm";
        }
        session.setAttribute("user",user);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/";
    }
}
