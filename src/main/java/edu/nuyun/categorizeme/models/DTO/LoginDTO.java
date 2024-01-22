package edu.nuyun.categorizeme.models.DTO;

import com.google.gson.Gson;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 21/01/2024
 * @package edu.nuyun.categorizeme.models
 * @project_Name CategorizeMe
 */
public record LoginDTO(String email, String password) {
    private final static Gson gson = new Gson();
    @Override
    public String toString() {
        return gson.toJson(this);
    }
}
