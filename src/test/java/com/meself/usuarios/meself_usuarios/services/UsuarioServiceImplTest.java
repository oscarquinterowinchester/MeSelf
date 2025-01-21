package com.meself.usuarios.meself_usuarios.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.meself.usuarios.meself_usuarios.DataProviders.DataProvider;
import com.meself.usuarios.meself_usuarios.basic.Utils;
import com.meself.usuarios.meself_usuarios.models.UsuarioEntity;
import com.meself.usuarios.meself_usuarios.repositories.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private Utils utils;

    @InjectMocks
    private UsuarioServiceImpl usuarioServiceImpl;

    @Test
    @Disabled
    public void testGetUsuarioEntityByUsuarioId() {
        Long usuarioId = 0L;

        UsuarioEntity usuarioEntity = usuarioRepository.getUsuarioEntityByUsuarioId(usuarioId);

        assertInstanceOf(UsuarioEntity.class, usuarioEntity, "El objeto no es una instancia de UsuarioEntity");

        assertEquals("Oscar", usuarioEntity.getNombre(), "El nombre del usuario no coincide");
    }

    @Test
    public void TestDeleteUsuariosEntityById() {
        //Given
        Long usuarioId = 1L;

        String dbType = "lorasdb";

        String nombre = "";

        UsuarioEntity usuario = DataProvider.geUsuarioDTO();
        
        //When

        this.usuarioServiceImpl.deleteUsuariosEntityById(usuarioId);

        //Then

        ArgumentCaptor<Long> longArgumentCaptor = ArgumentCaptor.forClass(Long.class);

        verify(this.usuarioRepository).deleteById(anyLong());
        verify(this.usuarioRepository).deleteById(longArgumentCaptor.capture());
        assertEquals(1L, longArgumentCaptor.getValue());

                // Validar que no sobrepasen los limites. 
                // Permite que se guarde sin dominio y arroba y guardar vacios.
                // Permite guardar contrasenas con un solo caracter y guardar vacios
                // No vacios en fechaNacimiento
                // nombre se puede guardar vacio, asi como apellido.
                // Siempre al guardar en las fechaCreacion y fechaNacimiento se pide que sean del tipo de dato esperado.

    }


}
