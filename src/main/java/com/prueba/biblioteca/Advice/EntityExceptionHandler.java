package com.prueba.biblioteca.Advice;

import com.prueba.biblioteca.Exception.BadRequestException;
import com.prueba.biblioteca.Exception.DataNotFoundException;
import com.prueba.biblioteca.Exception.ErrorDTO;
import lombok.extern.slf4j.Slf4j;
//import org.apache.coyote.BadRequestException;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class EntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ MethodArgumentNotValidException.class })
    public ResponseEntity<List<ErrorDTO>> getBadRequestException(MethodArgumentNotValidException e) {
        log.error(e.getMessage());
        List<ErrorDTO> error = new ArrayList<>();
        e.getBindingResult().getAllErrors().forEach(
                objectError -> {
                    ErrorDTO errorDTO = ErrorDTO.builder().code("P-400").nombre(objectError.getObjectName())
                            .message(objectError.getDefaultMessage()).build();
                    error.add(errorDTO);
                }
        );

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ BadRequestException.class })
    public ResponseEntity<ErrorDTO> getBadRequestException(BadRequestException e) {
        log.error(e.getMessage());
        ErrorDTO error = ErrorDTO.builder().code("P-400").message(e.getMessage()).build();
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = { DataNotFoundException.class })
    protected ResponseEntity<ErrorDTO> handleNotAcceptable(DataNotFoundException ex) {
        log.info(ex.getMessage());
        return new ResponseEntity<>(ex.getErrorDto(), HttpStatus.NOT_FOUND);
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<ErrorDTO> internalError(Exception ex) {

        log.error(ex.getMessage());
        ErrorDTO error = ErrorDTO.builder().code("P-500").nombre("Internal Server Error")
                .message("Error en el servidor, comuniquese con el propietario").build();
        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
