package portalNoticias.portalNoticia_Sql_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "articulos")
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_articulo;
    @ManyToOne
    @JoinColumn(name = "id_editor")
    private Editor editor;
    private String texto;
    @OneToMany(mappedBy = "articulo")
    private List<Comentario> comentarios;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    @JsonIgnore
    private Categoria categoria;
    @ManyToMany
    @JoinTable(name = "articulo_usuario",
    joinColumns = @JoinColumn(name = "id_articulo"),
    inverseJoinColumns = @JoinColumn(name = "id_usuario"))
    private List<Usuario> usuarios;

    public Articulo() {
    }

    public Articulo(Editor editor, String texto, Categoria categoria) {
        this.editor = editor;
        this.texto = texto;
        this.categoria = categoria;
    }
    public void afegirUsusrio(Usuario usuario){
        usuarios.add(usuario);
    }
    public void afegirComentario(Comentario comentario){
        comentarios.add(comentario);
    }

    public Long getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(Long id_articulo) {
        this.id_articulo = id_articulo;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
