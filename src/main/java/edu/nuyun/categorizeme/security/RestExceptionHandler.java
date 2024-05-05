package edu.nuyun.categorizeme.security;

import edu.nuyun.categorizeme.Exceptions.AppException;
import edu.nuyun.categorizeme.models.DTO.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 05/05/2024
 * @package edu.nuyun.categorizeme.security
 * @project_Name CategorizeMe
 */
@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = {AppException.class})
    @ResponseBody
    public ResponseEntity<ErrorDTO> handleException(AppException appException) {
        return ResponseEntity.status(appException.getCode())
                .body(ErrorDTO.builder().message(appException.getMessage()).build());
    }
}
