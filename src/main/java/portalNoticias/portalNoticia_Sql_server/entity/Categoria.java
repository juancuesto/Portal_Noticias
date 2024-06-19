package portalNoticias.portalNoticia_Sql_server.entity;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;
    private String categoriaArticulo;
    @OneToMany(mappedBy = "categoria")
    private List<Articulo> articulos;

    public Categoria() {
    }

    public Categoria(String categoriaArticulo) {
        this.categoriaArticulo = categoriaArticulo;
    }
    public void afegirArticulo(Articulo articulo){
        articulos.add(articulo);
    }

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getCategoriaArticulo() {
        return categoriaArticulo;
    }

    public void setCategoriaArticulo(String categoriaArticulo) {
        this.categoriaArticulo = categoriaArticulo;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }
}
