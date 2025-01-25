package com.meself.usuarios.meself_usuarios.basic;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.*;
import org.mockito.junit.jupiter.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.meself.usuarios.meself_usuarios.DTO.UsuarioDTO;
import com.meself.usuarios.meself_usuarios.DataProviders.DataProvider;



// @ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TestUsuarioUtils {


//@Mock
    @Autowired
    Utils utils;

   // @InjectMocks
   @Autowired
    UsuarioUtils usuarioUtils;



@Test
@Disabled
void TestEsNombreInvalido_happy(){

    // Given
    UsuarioDTO usuarioDTO = DataProvider.getUsuarioDTO();
    

   // usuarioDTO.setNombre(null);

    // when
    boolean esNombreInvalido = usuarioUtils.esNombreInvalido(usuarioDTO);

   // assertThrows(InvalidUserException.class, usuarioUtils.esNombreInvalido(usuarioDTO));

    assertFalse(esNombreInvalido);
    assertNotNull(esNombreInvalido);

}

@Test
@Disabled
void TestEsNombreInvalido_limited(){

    String nombre = DataProvider.lenght45();

   // System.out.println(nombre.length());

    // Given
    UsuarioDTO usuarioDTO = DataProvider.getUsuarioDTO();

    usuarioDTO.setApellidoPaterno(nombre);

    // when
    boolean esNombreInvalido = usuarioUtils.esNombreInvalido(usuarioDTO);

   // assertThrows(InvalidUserException.class, usuarioUtils.esNombreInvalido(usuarioDTO));

    assertNotNull(esNombreInvalido);
    assertInstanceOf(Boolean.class, usuarioUtils.esNombreInvalido(usuarioDTO));
    assertTrue(esNombreInvalido);

}

@Test
    public void esUsuarioEntityInvalido(){

        UsuarioDTO usuarioDTO = DataProvider.getUsuarioDTO();

        usuarioDTO.setNombre("1");

        usuarioUtils.esUsuarioEntityInvalido(usuarioDTO);

}

@Test
    public void esUsuarioEntityInvalido_Email(){

        UsuarioDTO usuarioDTO = DataProvider.getUsuarioDTO();

        usuarioDTO.setEmail("1@.com");

        usuarioUtils.esUsuarioEntityInvalido(usuarioDTO);

}

@Test
    public void esUsuarioEntityInvalido_Pass(){

        UsuarioDTO usuarioDTO = DataProvider.getUsuarioDTO();

        usuarioDTO.setContrasena(DataProvider.lenght45()+DataProvider.lenght45()+DataProvider.lenght45());

        usuarioUtils.esUsuarioEntityInvalido(usuarioDTO);

}



}
