package edu.nuyun.categorizeme.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 21/01/2024
 * @package edu.nuyun.categorizeme.models
 * @project_Name CategorizeMe
 */
@Setter
@Getter
@Entity
@Table(name="roles", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;
    public Role(String name) {
        this.name = name;
    }
    public Role() {

    }
}
