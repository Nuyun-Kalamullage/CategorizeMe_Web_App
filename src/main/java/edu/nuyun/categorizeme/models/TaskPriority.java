package edu.nuyun.categorizeme.models;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 15/01/2024
 * @package edu.nuyun.categorizeme.models
 * @project_Name CategorizeMe
 */
public enum TaskPriority {
    VERY_IMPORTANT("Very Important"),
    IMPORTANT("Important"),
    NOT_IMPORTANT("Not Important");

    private final String label;

    TaskPriority(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
