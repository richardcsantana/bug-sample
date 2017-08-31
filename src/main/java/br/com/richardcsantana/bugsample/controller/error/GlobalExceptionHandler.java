package br.com.richardcsantana.bugsample.controller.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author richardsantana
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ErrorDataview methodArgumentNotValidHandler(final MethodArgumentNotValidException ex){
        log.error(ex.getMessage(),ex);
        return new ErrorDataview("verify the contract",HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = {Exception.class})
    public ErrorDataview ExceptionHandler(final Exception ex){
        log.error(ex.getMessage(),ex);
        return new ErrorDataview("some error",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
