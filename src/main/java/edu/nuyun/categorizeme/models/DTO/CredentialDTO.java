package edu.nuyun.categorizeme.models.DTO;

import lombok.*;
import org.springframework.stereotype.Service;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 05/05/2024
 * @package edu.nuyun.categorizeme.models.DTO
 * @project_Name CategorizeMe
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CredentialDTO {
    private String email;
    private char[] password;
}
