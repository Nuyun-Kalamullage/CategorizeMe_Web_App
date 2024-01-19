package edu.nuyun.categorizeme.models;

import jakarta.persistence.*;
import lombok.Getter;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 19/01/2024
 * @package edu.nuyun.categorizeme.models
 * @project_Name CategorizeMe
 */
@Entity
@Table
public class UserTable{
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")

    private Long userId;
    @Getter
    private String name;
    @Getter
    private String email;

    public UserTable(String name, String email){
        this.name = name;
        this.email = email;
    }
    public UserTable(){}

    @Override
    public String toString() {
        return "UserTable{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
