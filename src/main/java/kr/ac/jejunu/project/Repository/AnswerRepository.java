package kr.ac.jejunu.project.Repository;

import kr.ac.jejunu.project.Model.Answer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Answer findByDay(String day);
    List<Answer> findAllByNum(Integer num);

}