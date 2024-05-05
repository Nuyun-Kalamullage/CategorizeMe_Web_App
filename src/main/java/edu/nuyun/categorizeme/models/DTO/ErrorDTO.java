package edu.nuyun.categorizeme.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 05/05/2024
 * @package edu.nuyun.categorizeme.models
 * @project_Name CategorizeMe
 */
@AllArgsConstructor
@Builder
@Data
public class ErrorDTO {
private String message;
}
