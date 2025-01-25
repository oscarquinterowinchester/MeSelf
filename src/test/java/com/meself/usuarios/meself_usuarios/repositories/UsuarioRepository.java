package com.meself.usuarios.meself_usuarios.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meself.usuarios.meself_usuarios.models.UsuarioEntity;


@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioEntity,Long>{

    @Query(value = "SELECT * FROM usuarios_tbl where usuario_id = (:usuario_id);", nativeQuery = true)
    public <Optional>UsuarioEntity getUsuarioEntityByUsuarioId(Long usuario_id);

    public void deleteUsuariosEntityByUsuarioId(Long usuarioId);

}
