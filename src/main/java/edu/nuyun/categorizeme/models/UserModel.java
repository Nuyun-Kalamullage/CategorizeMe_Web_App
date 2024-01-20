package edu.nuyun.categorizeme.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 19/01/2024
 * @package edu.nuyun.categorizeme.models
 * @project_Name CategorizeMe
 */
@Entity
@Table
public class UserModel {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")

    @Getter
    @Setter
    private Long userId;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String email;

    public UserModel(Long userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public UserModel(String name, String email){
        this.name = name;
        this.email = email;
    }
    public UserModel(){}

    @Override
    public String toString() {
        return "UserTable{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
