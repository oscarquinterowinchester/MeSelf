package com.meself.usuarios.meself_usuarios.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.meself.usuarios.meself_usuarios.DataProviders.DataProvider;
import com.meself.usuarios.meself_usuarios.basic.Utils;
import com.meself.usuarios.meself_usuarios.models.UsuarioEntity;
import com.meself.usuarios.meself_usuarios.repositories.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
// @SpringBootTest
public class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private Utils utils;

    @InjectMocks
    private UsuarioServiceImpl usuarioServiceImpl;


    // @Autowired
    // private UsuarioServiceImpl usuarioServiceImpl;



    // @Test
    // @Disabled
    //  void TestGetUsuarioEntityByUsuarioId_happy() {

    //     Long usuarioId = 1L;

    //     when(usuarioRepository.getUsuarioEntityByUsuarioId(usuarioId)).thenReturn(DataProvider.geUsuarioEntity());
        
    //     UsuarioEntity user = usuarioServiceImpl.getUsuarioEntityByUsuarioId(usuarioId);

    //     assertEquals("Oscar", user.getNombre());

    //    verify(usuarioRepository).getUsuarioEntityByUsuarioId(anyLong());
    // }





//     @Test
//     @Disabled
//     void TestGetUsuarioEntityByUsuarioId_limited() {

//        Long usuarioId = 1L;
       
//        UsuarioEntity user = usuarioServiceImpl.getUsuarioEntityByUsuarioId(usuarioId);


//        assertEquals("Oscar", user.getNombre());
//        assertEquals("Tellez", user.getApellidoMaterno());
//        assertEquals("Quintero", user.getApellidoPaterno());
//        assertEquals(true, user.isEstatus());
//        assertEquals("Oski", user.getSobrenombre());
//        assertInstanceOf(LocalDateTime.class, user.getFechaCreacion());
//        assertInstanceOf(LocalDate.class, user.getFechaNacimiento());
//        assertNotNull(user);

//    }

    //     @Override
    // public UsuarioEntity getUsuarioEntityByUsuarioId(Long usuarioId) {
        
    //     return usuarioRepository.getUsuarioEntityByUsuarioId(usuarioId);
    // }

    @Test
    @Disabled
    public void TestDeleteUsuariosEntityById() {
        //Given
        Long usuarioId = 1L;
        
        //When

        this.usuarioServiceImpl.deleteUsuariosEntityById(usuarioId);

        //Then

        ArgumentCaptor<Long> longArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        // ArgumentCaptor<Long> longArgumentCaptor = ArgumentCaptor.forClass(Long.class);

        // verify(this.usuarioRepository).deleteUsuariosEntityByUsuarioId(anyLong());
        verify(this.usuarioRepository).deleteById(longArgumentCaptor.capture());

        assertEquals(usuarioId, longArgumentCaptor.getValue());

    }


}
