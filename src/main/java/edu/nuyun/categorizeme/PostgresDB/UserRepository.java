package edu.nuyun.categorizeme.PostgresDB;

import edu.nuyun.categorizeme.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
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
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("SELECT s from User s WHERE s.email = ?1")
    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByUserId(Long userID);

//    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.email = :email")
    boolean existsUserByEmail(String email);
}
