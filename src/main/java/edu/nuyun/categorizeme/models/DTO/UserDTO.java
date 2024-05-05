package edu.nuyun.categorizeme.models.DTO;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 05/05/2024
 * @package edu.nuyun.categorizeme.models.DTO
 * @project_Name CategorizeMe
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO{
    private final static Gson gson = new Gson();
    private Long id;
    private String name;
    private String email;
    private String token;

    @Override
    public String toString() {
        return gson.toJson(this);
    }
}

