package kr.ac.jejunu.project.Controller;

import kr.ac.jejunu.project.Model.Question;
import kr.ac.jejunu.project.Repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/question")
@AllArgsConstructor
public class QuestionController {
    @Autowired
    QuestionRepository g;

    @GetMapping("/search")
    public Question get(@RequestParam(value = "day") String day){
        return answerRepository.findByDay(day);
    }

    @PostMapping("")
    public String create(String answer){
        return "redirect:/tour";
    }

}
