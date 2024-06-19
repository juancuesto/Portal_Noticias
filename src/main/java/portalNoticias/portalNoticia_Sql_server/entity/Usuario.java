package portalNoticias.portalNoticia_Sql_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    private String nombre;
    private String apellidos;
    private Boolean suscripcion;
    @ManyToMany
    @JoinTable(name = "articulo_usuario",
    joinColumns = @JoinColumn(name = "id_usuario"),
    inverseJoinColumns = @JoinColumn(name = "id_articulo"))
    @JsonIgnore
    private List<Articulo> articulosConsultados;

    public Usuario() {
    }

    public Usuario(String nombre, String apellidos, Boolean suscripcion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.suscripcion = suscripcion;
    }
    public void afegirArticuloConsultado(Articulo articulo){
        articulosConsultados.add(articulo);
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
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

    public Boolean getSuscripion() {
        return suscripcion;
    }

    public void setSuscripion(Boolean suscripion) {
        this.suscripcion = suscripion;
    }

    public List<Articulo> getArticulosConsultados() {
        return articulosConsultados;
    }

    public void setArticulosConsultados(List<Articulo> articulosConsultados) {
        this.articulosConsultados = articulosConsultados;
    }
}
