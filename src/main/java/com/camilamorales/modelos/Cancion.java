package com.camilamorales.modelos;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "canciones")

public class Cancion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 5, message="Debe tener al menos 5 caracteres")
    private String titulo;

    @NotBlank
    @Size(min = 3, message="Debe tener al menos 3 caracteres")
    private String artista;

    @NotBlank
    @Size(min = 3, message="Debe tener al menos 3 caracteres")
    private String album;

    @NotBlank
    @Size(min = 3, message="Debe tener al menos 3 caracteres")
    private String genero;

    @NotBlank
    @Size(min = 3, message="Debe tener al menos 3 caracteres")
    private String idioma;
    
    @Column(name = "fecha_creacion", updatable = false, nullable = false)
    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion", updatable = true)
    private LocalDateTime fechaActualizacion;
    

    @PrePersist
    public void onCreate(){
        this.fechaCreacion = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate(){
        this.fechaActualizacion = LocalDateTime.now();
    }

    public Cancion(){

    }

    //Getters y Setters 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }


}

