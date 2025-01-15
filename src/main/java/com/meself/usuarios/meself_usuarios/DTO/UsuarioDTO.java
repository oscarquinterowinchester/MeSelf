package com.meself.usuarios.meself_usuarios.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioDTO {

    public UsuarioDTO(){

        fechaCreacion = LocalDateTime.now();
        estatus = true;
    }

    private String nombre;

    private String apellidoPaterno;

    private String apellidoMaterno;

     private String email;

     private String contrasena;

    private LocalDateTime fechaCreacion;

    private LocalDate fechaNacimiento;

    private String sobrenombre;

    private boolean estatus;


}
