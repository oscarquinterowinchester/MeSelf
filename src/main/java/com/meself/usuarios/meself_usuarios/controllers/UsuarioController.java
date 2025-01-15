package com.meself.usuarios.meself_usuarios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meself.usuarios.meself_usuarios.DTO.UsuarioDTO;
import com.meself.usuarios.meself_usuarios.models.UsuarioEntity;
import com.meself.usuarios.meself_usuarios.services.IUsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

@Autowired
IUsuarioService usuarioService;


    @PostMapping("/createUsuario")
    public ResponseEntity<?> createUsuario(@RequestBody UsuarioDTO usuarioDTO){

        return ResponseEntity.ok(usuarioService.createUsuarioEntity(usuarioDTO));
    }

    @GetMapping("/getUsuario/{usuarioId}")
    public ResponseEntity<?> getUserById(@PathVariable Long usuarioId){

        UsuarioEntity usuarioEntity = usuarioService.getUsuarioEntityByUsuarioId(usuarioId);

        return ResponseEntity.ok(usuarioEntity);
    }

    @GetMapping("/hello")
    public String hello(){

        return "Hola amios";
    }

    @DeleteMapping("/deleteUsuario/{usuarioId}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long usuarioId){

         usuarioService.deleteUsuariosEntityById(usuarioId);

        return ResponseEntity.ok("Usuario Eliminado");
    }



}
