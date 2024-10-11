package com.assembleia.handlers;


import com.assembleia.domain.RetornoErro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MethodArgumentNotValidHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RetornoErro> handleException(MethodArgumentNotValidException e) {
        RetornoErro erros = new RetornoErro();
        e.getAllErrors().forEach(objectError -> erros.getErros().add(objectError.getDefaultMessage()));
        return ResponseEntity.badRequest().body(erros);
    }


}

