package com.meself.usuarios.meself_usuarios.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExcepcionController {



        @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        // Crear una respuesta personalizada
        Map<String, String> response = new HashMap<>();
        response.put("error", "Data integrity violation");
        response.put("message", ex.getRootCause() != null ? ex.getRootCause().getMessage() : ex.getMessage());
        
        // Retornar una respuesta con código 409 (Conflict)
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }



}
