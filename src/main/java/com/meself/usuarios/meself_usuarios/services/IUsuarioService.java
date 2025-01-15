package com.meself.usuarios.meself_usuarios.services;

import org.springframework.stereotype.Service;

import com.meself.usuarios.meself_usuarios.DTO.UsuarioDTO;
import com.meself.usuarios.meself_usuarios.models.UsuarioEntity;

@Service
public interface IUsuarioService {

    public UsuarioEntity getUsuarioEntityByUsuarioId(Long usuarioId);

    public void deleteUsuariosEntityById(Long usuarioId);

    public UsuarioEntity createUsuarioEntity(UsuarioDTO usuarioDTO);

}
