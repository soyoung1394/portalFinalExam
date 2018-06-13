package kr.ac.jejunu.project.Controller;

import kr.ac.jejunu.project.Model.Answer;
import kr.ac.jejunu.project.Repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping("/answerForm")
    public String answer(){
        return "/answer";
    }
    @PostMapping("")
    public String create(String day, String question, String answer){
        Answer newAnswer=new Answer(day, question, answer);
        answerRepository.save(newAnswer);
        return "redirect:/";
    }

}
