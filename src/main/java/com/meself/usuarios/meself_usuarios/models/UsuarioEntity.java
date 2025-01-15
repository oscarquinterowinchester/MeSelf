package com.meself.usuarios.meself_usuarios.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "usuarios_tbl")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usuarioId;

    @Column(nullable = false, length = 45)
    @NotNull
    @Size(min = 1, max = 45, message = "El nombre debe tener entre 1 y 45 caracteres.")
    private String nombre;

    @Column(name = "apellido_paterno", nullable = false, length = 30)
    @NotNull
    @Size(min = 1, max = 30, message = "El apellido paterno debe tener entre 1 y 30 caracteres.")
    private String apellidoPaterno;

    @Column(name = "apellido_materno", length = 25)
    @Size(max = 25, message = "El apellido materno no puede exceder 25 caracteres.")
    private String apellidoMaterno;

    @Column(nullable = false, length = 80, unique = true)
    @NotNull
    @Email(message = "Debe proporcionar un correo electrónico válido.")
    @Size(max = 80, message = "El email no puede exceder 80 caracteres.")
    private String email;

    @Column(nullable = false)
    @NotNull
    private String contrasena;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(length = 45)
    @Size(max = 45, message = "El sobrenombre no puede exceder 45 caracteres.")
    private String sobrenombre;

    @Column(nullable = false)
    @NotNull
    private boolean estatus;



}
