package kr.ac.jejunu.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/answer")
public class AnswerController {
    @GetMapping("/answerForm")
    public String answer(){
        return "/answer";
    }
}
