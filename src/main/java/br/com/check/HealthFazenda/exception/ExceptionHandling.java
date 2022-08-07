package br.com.check.HealthFazenda.exception;

import br.com.check.HealthFazenda.errors.StanderError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StanderError>objectNotFound(ObjectNotFoundException ex, HttpServletRequest httpServletRequest){
        StanderError error = new StanderError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage(), httpServletRequest.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<StanderError>exception(Exception ex, HttpServletRequest httpServletRequest){
        StanderError error = new StanderError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage(), httpServletRequest.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
