package edu.nuyun.categorizeme.PostgresDB;

import edu.nuyun.categorizeme.models.Task;
import edu.nuyun.categorizeme.models.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 20/01/2024
 * @package edu.nuyun.categorizeme.PostgresDB
 * @project_Name CategorizeMe
 */
@Repository
public interface UserRepository extends JpaRepository<UserTable, Long> {
}
