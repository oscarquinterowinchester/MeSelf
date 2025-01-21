package com.meself.usuarios.meself_usuarios.basic;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.meself.usuarios.meself_usuarios.DTO.UsuarioDTO;
import com.meself.usuarios.meself_usuarios.Exceptions.InvalidUserException;

@ExtendWith(MockitoExtension.class)
public class TestUsuarioUtils {


    @Mock
    Utils utils;

    @InjectMocks
    UsuarioUtils usuarioUtils;

    public boolean esUsuarioEntityInvalido(UsuarioDTO usuarioDTO){


    if(esNombreInvalido(usuarioDTO)){

        return true;
    }
    if(esEmailInvalido(usuarioDTO)){

        return true;
    }
    if(esContrasenaInvalida(usuarioDTO)){

        return true;
    }
    if(esFechaInvalida(usuarioDTO)){

        return true;
    }

return false;
}

private void arrojarInvalidUser(String mensajeError){

    throw new InvalidUserException(mensajeError);
}

private boolean esFechaInvalida(UsuarioDTO usuarioDTO) {
    LocalDate fechaNac = usuarioDTO.getFechaNacimiento();

    // Verifica si la fecha es nula
    if (fechaNac == null) {
        throw new InvalidUserException("Fecha de nacimiento: esta vacio o es nulo");
    }

    // Verifica si la fecha está en el futuro
    if (fechaNac.isAfter(LocalDate.now())) {
        throw new InvalidUserException("Fecha de nacimiento: no puede estar en el futuro.");
    }

    // Verifica si la fecha es demasiado antigua (por ejemplo, antes de 1900)
    if (fechaNac.isBefore(LocalDate.of(1900, 1, 1))) {
        throw new InvalidUserException("Fecha de nacimiento: no puede ser anterior al año 1900.");
    }

    // Si todas las validaciones son correctas
    return false;
}


private boolean esEmailInvalido(UsuarioDTO usuarioDTO){

    String email = usuarioDTO.getEmail();

    if(utils.isObjectInvalid(email)){

        arrojarInvalidUser("Correo: esta vacio o es nulo");
    }

    if(utils.isInvalidLenght_str(email,80,8)){

        arrojarInvalidUser("Correo: longitud invalida");
    }
    if(utils.isInvalidEmail(email)){
        arrojarInvalidUser("Correo: dominio invalido");
    }

    return false;

}

private boolean esContrasenaInvalida(UsuarioDTO usuarioDTO){

    String contrasena = usuarioDTO.getContrasena();

    if(utils.isObjectInvalid(contrasena)){

        arrojarInvalidUser("Contrasena: esta vacio o es nulo");
    }

    if(utils.isInvalidLenght_str(contrasena,60,1)){

        arrojarInvalidUser("Contrasena: longitud invalida");
    }

    return false;

}


void TestEsNombreInvalido(){


    

}


@Test
@Disabled
private boolean esNombreInvalido(UsuarioDTO usuarioDTO){

    String nombre = usuarioDTO.getNombre();
    String apellidoPaterno = usuarioDTO.getApellidoPaterno();

    if(utils.isObjectInvalid(nombre)){

        arrojarInvalidUser("Nombre: esta vacio o es nulo");
    }
    if(utils.isObjectInvalid(apellidoPaterno) ){
        arrojarInvalidUser("Apellido paterno: esta vacio o es nulo");
    }

    if(utils.isInvalidLenght_str(nombre,45,1)){

        arrojarInvalidUser("Nombre: longitud invalida");
    }
    if(utils.isInvalidLenght_str(apellidoPaterno, 45, 1)){
        arrojarInvalidUser("Apellido paterno: longitud invalida");
    }

    return false;

}

}
