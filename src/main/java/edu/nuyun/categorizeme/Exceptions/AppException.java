package edu.nuyun.categorizeme.Exceptions;

import org.springframework.http.HttpStatus;

/**
 * @author Nuyun-Kalamullage
 * @IDE IntelliJ IDEA
 * @date 05/05/2024
 * @package edu.nuyun.categorizeme.Exceptions
 * @project_Name CategorizeMe
 */
public class AppException extends RuntimeException {
    private final HttpStatus code;
    public AppException(String message, HttpStatus httpStatusCode) {
        super(message);
        this.code = httpStatusCode;
    }

    public HttpStatus getCode() {
        return code;
    }
}
