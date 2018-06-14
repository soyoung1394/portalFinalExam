package kr.ac.jejunu.project.Controller;

import kr.ac.jejunu.project.Repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TourController {
    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping("tour")
    public String tour(Model model){
        model.addAttribute("answer",answerRepository.findAll());
        return "tour";
    }
    @GetMapping("detail")
    public String detail(Model model){
        model.addAttribute("answer",answerRepository.findAll());
        return "detail";
    }
}
