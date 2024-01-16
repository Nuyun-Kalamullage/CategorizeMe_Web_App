package edu.nuyun.categorizeme.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 15/01/2024
 * @package edu.nuyun.categorizeme.models
 * @project_Name CategorizeMe
 */
public record Task (String id, String title, String description, Category category, TaskPriority taskPriority) {
    private static final Gson gson = new Gson();
    @Override
    public String toString() {
        return gson.toJson(this);
    }
}
