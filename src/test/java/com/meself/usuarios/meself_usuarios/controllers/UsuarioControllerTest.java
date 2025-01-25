package com.meself.usuarios.meself_usuarios.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.net.http.HttpResponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.meself.usuarios.meself_usuarios.DTO.UsuarioDTO;
import com.meself.usuarios.meself_usuarios.DataProviders.DataProvider;
import com.meself.usuarios.meself_usuarios.basic.Utils;
import com.meself.usuarios.meself_usuarios.services.IUsuarioService;

@ExtendWith(MockitoExtension.class)
public class UsuarioControllerTest {

@Mock
IUsuarioService usuarioService;

@Mock
Utils utils;

@InjectMocks
UsuarioController usuarioController;




@Test
    void createUsuario(){


        UsuarioDTO usuarioDTO = DataProvider.getUsuarioDTO();

        System.out.println(usuarioDTO.toString());

        ResponseEntity responseEntity = usuarioController.createUsuario(null);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());


    }

    // @PostMapping("/createUsuario")
    // public ResponseEntity<?> createUsuario(@RequestBody UsuarioDTO usuarioDTO){

    //     if(utils.isObjectInvalid(usuarioDTO)){
    //         return ResponseEntity.badRequest().body("Parametro necesario: usuario");
    //      }

    //     return ResponseEntity.ok(usuarioService.createUsuarioEntity(usuarioDTO));
    // }



}
