package com.meself.usuarios.meself_usuarios.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meself.usuarios.meself_usuarios.DTO.UsuarioDTO;
import com.meself.usuarios.meself_usuarios.basic.UsuarioUtils;
import com.meself.usuarios.meself_usuarios.basic.Utils;
import com.meself.usuarios.meself_usuarios.models.UsuarioEntity;
import com.meself.usuarios.meself_usuarios.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    Utils utils;

    @Autowired
    UsuarioUtils usuarioUtils;

    @Override
    public UsuarioEntity getUsuarioEntityByUsuarioId(Long usuarioId) {
        
        return usuarioRepository.getUsuarioEntityByUsuarioId(usuarioId);
    }

    @Override
    public void deleteUsuariosEntityById(Long usuarioId) {

        usuarioRepository.deleteById(usuarioId);
        
    }

    @Override
    public UsuarioEntity createUsuarioEntity(UsuarioDTO usuarioDTO) {

        utils.isObjectInvalid(usuarioDTO);

        usuarioUtils.esUsuarioEntityInvalido(usuarioDTO);


        UsuarioEntity usuarioEntity = UsuarioEntity.builder()
        .nombre(usuarioDTO.getNombre())
        .apellidoPaterno(usuarioDTO.getApellidoPaterno())
        .apellidoMaterno(usuarioDTO.getApellidoMaterno())
        .email(usuarioDTO.getEmail())
        .fechaNacimiento(usuarioDTO.getFechaNacimiento())
        .contrasena(usuarioDTO.getContrasena())
        .fechaCreacion(usuarioDTO.getFechaCreacion())
        .build();

        
       return usuarioRepository.save(usuarioEntity);
    }



}


