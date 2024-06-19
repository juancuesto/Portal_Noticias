package portalNoticias.portalNoticia_Sql_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portalNoticias.portalNoticia_Sql_server.entity.Articulo;
import portalNoticias.portalNoticia_Sql_server.repository.ArticuloRepository;

import java.util.List;

@Service
public class ArticuloService {
    @Autowired
    private ArticuloRepository articuloRepository;

    /**
     * Guardar un articulo nueco en base de datos
     * @param articulo el articulo a guardar
     * @return el articulo guardado
     */
    public Articulo crearArticulo(Articulo articulo){
        return articuloRepository.save(articulo);
    }

    /**
     * obtenemos articulo por id
     * @param id el id del articulo buscado
     * @return el articulo encontrado, sino lo encuentra devuelve null
     */
    public Articulo getArticuloById(Long id){
        return articuloRepository.findById(id).orElse(null);
    }

    /**
     * obtenemos listado de todos los articulos
     * @return listado con los articulos en base de datos
     */
    public List<Articulo> getAllArticulos(){
        return articuloRepository.findAll();
    }

    /**
     * borra articulo en base de datos por id
     * @param id el id del articulo a borrar
     */
    public void deleteArticuloById(Long id){
        articuloRepository.deleteById(id);
    }
}

