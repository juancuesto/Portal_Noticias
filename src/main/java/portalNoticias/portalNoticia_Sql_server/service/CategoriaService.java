package portalNoticias.portalNoticia_Sql_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portalNoticias.portalNoticia_Sql_server.entity.Categoria;
import portalNoticias.portalNoticia_Sql_server.repository.CategoriaRepository;

import java.util.List;
@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    /**
     * Guardar una Categoria nueva en base de datos
     * @param categoria la Categoria a guardar
     * @return la Categoria guardada
     */
    public Categoria crearCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    /**
     * obtenemos Categoria por id
     * @param id el id de la Categoria buscada
     * @return la Categoria encontrada, sino la encuentra devuelve null
     */
    public Categoria getCategoriaById(Long id){
        return categoriaRepository.findById(id).orElse(null);
    }

    /**
     * obtenemos listado de todos las Categorias
     * @return listado con las Categoria en base de datos
     */
    public List<Categoria> getAllCategorias(){
        return categoriaRepository.findAll();
    }

    /**
     * borra Categoria en base de datos por id
     * @param id el id de la Categoria a borrar
     */
    public void deleteCategoriaById(Long id){
        categoriaRepository.deleteById(id);
    }
}
