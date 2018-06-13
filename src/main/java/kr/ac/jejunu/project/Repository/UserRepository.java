package kr.ac.jejunu.project.Repository;

import kr.ac.jejunu.project.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);
}
