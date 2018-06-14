package kr.ac.jejunu.project.Controller;

import com.sun.tracing.dtrace.Attributes;
import kr.ac.jejunu.project.Model.Answer;
import kr.ac.jejunu.project.Repository.AnswerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping("/answerForm")
    public String answer(){
        return "/answer";
    }
    @PostMapping
    @ResponseBody
    public Answer create(@RequestBody Answer answer){
        return  answerRepository.save(answer);
    }

    @PutMapping
      public void update(@RequestBody Answer answer){
        answerRepository.save(answer);
    }
    @GetMapping("/search")
    @ResponseBody
    public Answer get(@RequestParam(value = "day") String day){
        return answerRepository.findByDay(day);
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Answer> list(){
        return answerRepository.findAll();
    }


    @GetMapping("/list/search")
    @ResponseBody
    public List<Answer> listByQuestion(@RequestParam Integer num){

        return answerRepository.findAllByNum(num);
    }
}
