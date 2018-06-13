package kr.ac.jejunu.project.Repository;

import kr.ac.jejunu.project.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
   Question findByDay(String day);
}
