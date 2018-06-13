package kr.ac.jejunu.project;

import kr.ac.jejunu.project.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);
}
