package com.meself.usuarios.meself_usuarios.DataProviders;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.meself.usuarios.meself_usuarios.DTO.UsuarioDTO;
import com.meself.usuarios.meself_usuarios.models.UsuarioEntity;

public class DataProvider {



    public static UsuarioEntity geUsuarioEntity(){

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

    public static UsuarioDTO getUsuarioDTO(){


        return UsuarioDTO.builder()
        .nombre("Oscar")
        .apellidoPaterno("Quintero")
        .apellidoMaterno("Tellez")
        .email("oscar123456@gmail.com")
        .fechaNacimiento(LocalDate.now())
        .contrasena("1234567")
        .build();
    

    }

    public static String lenght45(){

        return "123456789012345678901234567890123456789012345";
    }

}
