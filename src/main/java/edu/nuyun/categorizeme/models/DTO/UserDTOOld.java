package edu.nuyun.categorizeme.models.DTO;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 22/01/2024
 * @package edu.nuyun.categorizeme.models.DTO
 * @project_Name CategorizeMe
 */
public record UserDTOOld(String name, String email) {
    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
