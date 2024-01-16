package edu.nuyun.categorizeme.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 15/01/2024
 * @package edu.nuyun.categorizeme.models
 * @project_Name CategorizeMe
 */
//@Data
@Document
public record Task (@Id String id, @Indexed(unique = true) String title, String description, Category category, TaskPriority taskPriority) {
    private static final Gson gson = new Gson();
    @Override
    public String toString() {
        return gson.toJson(this);
    }
}
