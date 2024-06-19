package portalNoticias.portalNoticia_Sql_server.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "editores")
public class Editor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_editor;
    private String nombre;
    private String apellidos;
    @OneToMany(mappedBy = "editor")
    private List<Articulo> articulos;
    @OneToMany(mappedBy = "editor")
    private List<Comentario> comentarios;

    public Editor() {
    }

    public Editor(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    public void afegirArticulo(Articulo articulo){
        articulos.add(articulo);
    }
    public void  afegirComentario(Comentario comentario){
        comentarios.add(comentario);
    }

    public Long getId_editor() {
        return id_editor;
    }

    public void setId_editor(Long id_editor) {
        this.id_editor = id_editor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "Editor{" +
                "id_editor=" + id_editor +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", articulos=" + articulos +
                ", comentarios=" + comentarios +
                '}';
    }
}
