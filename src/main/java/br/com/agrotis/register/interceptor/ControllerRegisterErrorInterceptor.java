package br.com.agrotis.register.interceptor;

import br.com.agrotis.register.exception.RegisterErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@ControllerAdvice
public class ControllerRegisterErrorInterceptor extends ResponseEntityExceptionHandler {

    @ExceptionHandler({MethodArgumentTypeMismatchException.class}) // 400
    public ResponseEntity<RegisterErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        log.error("Erro ao executar requisição.", ex);
        HttpStatus httpStatus = BAD_REQUEST;
        RegisterErrorResponse apiError = new RegisterErrorResponse(httpStatus, "Requisição malformada", "Requisição malformada.");
        return new ResponseEntity<>(apiError, httpStatus);
    }
}