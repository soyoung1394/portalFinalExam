package kr.ac.jejunu.project.Controller;

import kr.ac.jejunu.project.Model.Question;
import kr.ac.jejunu.project.Repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/question")
@AllArgsConstructor
public class QuestionController {
    @Autowired
    QuestionRepository questionRepository;

    @GetMapping("/search")
    public Question get(@RequestParam(value = "day") String day){
        return questionRepository.findByDay(day);
    }

}
