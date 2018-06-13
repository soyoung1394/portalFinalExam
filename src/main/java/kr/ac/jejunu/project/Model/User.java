package kr.ac.jejunu.project.Model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    private String userId;
    private String password;
    private String name;
    private String email;


    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
