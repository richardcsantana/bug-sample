package br.com.richardcsantana.bugsample.controller.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @author richardsantana
 */
@Data
@AllArgsConstructor
public class ErrorDataview {
    private String message;
    private HttpStatus status;
}
