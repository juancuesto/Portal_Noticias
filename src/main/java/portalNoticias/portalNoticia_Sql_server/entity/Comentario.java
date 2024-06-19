package portalNoticias.portalNoticia_Sql_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
@Entity
@Table(name = "comentarios")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_comentario;
    @ManyToOne
    @JoinColumn(name = "id_articulo")
    @JsonIgnore
    private Articulo articulo;
    @ManyToOne
    @JoinColumn(name = "id_editor")
    @JsonIgnore
    private Editor editor;

    public Comentario() {
    }

    public Comentario(Articulo articulo, Editor editor) {
        this.articulo = articulo;
        this.editor = editor;
    }

    public Long getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(Long id_comentario) {
        this.id_comentario = id_comentario;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }
}
