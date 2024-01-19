package edu.nuyun.categorizeme.MongoDB;

import edu.nuyun.categorizeme.models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 16/01/2024
 * @package edu.nuyun.categorizeme.MongoDB
 * @project_Name CategorizeMe
 */
@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
    Optional<Task> findTaskByTitle(String title);
//    @Query("")
//    void test();
}
