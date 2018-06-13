package kr.ac.jejunu.project.Model;

import lombok.Data;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    private String day;
    private String answer;

    public Answer() {}

    public Answer(String day, String question, String answer) {
        super();
        this.day = day;
        this.question = question;
        this.answer = answer;
    }
}
