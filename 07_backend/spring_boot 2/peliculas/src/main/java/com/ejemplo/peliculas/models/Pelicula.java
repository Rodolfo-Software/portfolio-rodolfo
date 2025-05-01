package com.ejemplo.peliculas.models;

public class Pelicula {
    private String id;
    private String titulo;
    private String descripcion;
    private String trailer;
    private String imagen;
    private String fechaEstreno;

    public Pelicula() {}

    public Pelicula(String id, String titulo, String descripcion, String trailer, String imagen, String fechaEstreno) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.trailer = trailer;
        this.imagen = imagen;
        this.fechaEstreno = fechaEstreno;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getTrailer() { return trailer; }
    public void setTrailer(String trailer) { this.trailer = trailer; }

    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }

    public String getFechaEstreno() { return fechaEstreno; }
    public void setFechaEstreno(String fechaEstreno) { this.fechaEstreno = fechaEstreno; }
}
