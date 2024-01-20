package edu.nuyun.categorizeme.PostgresDB;

import edu.nuyun.categorizeme.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 20/01/2024
 * @package edu.nuyun.categorizeme.PostgresDB
 * @project_Name CategorizeMe
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    @Query("SELECT s from UserModel s WHERE s.email = ?1")
    Optional<UserModel> findUserModelByEmail(String email);
}
