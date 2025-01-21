package com.meself.usuarios.meself_usuarios.DataProviders;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.meself.usuarios.meself_usuarios.DTO.UsuarioDTO;
import com.meself.usuarios.meself_usuarios.models.UsuarioEntity;

public class DataProvider {



    public static UsuarioEntity geUsuarioDTO(){

        return UsuarioEntity.builder()
                .nombre("Oscar")
                .apellidoPaterno("Quintero")
                .apellidoMaterno("Tellez")
                .email("oscar@")
                .fechaNacimiento(LocalDate.now())
                .contrasena("1234567")
                .fechaCreacion(LocalDateTime.now())
                .build();
    }

}
