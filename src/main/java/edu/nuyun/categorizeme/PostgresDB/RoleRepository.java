package edu.nuyun.categorizeme.PostgresDB;

import edu.nuyun.categorizeme.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional; /**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 21/01/2024
 * @package edu.nuyun.categorizeme.PostgresDB
 * @project_Name CategorizeMe
 */;


public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
