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
    @ExceptionHandler(value = { DataNotFoundException.class })
    protected ResponseEntity<ErrorDTO> handleNotAcceptable(RuntimeException ex) {
        DataNotFoundException dex = (DataNotFoundException) ex;
        String msj = "Error en la clase: " + dex.getExceptionClass().getName() + " al tratar de buscar: "
                + dex.getNotFoundClass() ;
        log.error(msj, ex);
        ErrorDTO error = ErrorDTO.builder().code("P-404").nombre(msj).message("NO EXISTE O ESTA EN USO").build();
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }


}
