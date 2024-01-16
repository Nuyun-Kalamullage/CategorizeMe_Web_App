package edu.nuyun.categorizeme.models;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 15/01/2024
 * @package edu.nuyun.categorizeme.models
 * @project_Name CategorizeMe
 */
public enum Category {
    WORK("Work"),
    HOME("Home"),
    STUDY("Study"),
    PERSONAL("Personal"),
    SHOPPING("Shopping"),
    OTHER("Other");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
