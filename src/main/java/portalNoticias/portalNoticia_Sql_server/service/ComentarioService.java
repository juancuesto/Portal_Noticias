package portalNoticias.portalNoticia_Sql_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portalNoticias.portalNoticia_Sql_server.entity.Comentario;
import portalNoticias.portalNoticia_Sql_server.repository.ComentarioRepository;

import java.util.List;

@Service
public class ComentarioService {
    @Autowired
    private ComentarioRepository comentarioRepository;

    /**
     * Guardar un Comentario nueva en base de datos
     * @param comentario el Comentario a guardar
     * @return el Comentario guardado
     */
    public Comentario crearComentario(Comentario comentario){
        return comentarioRepository.save(comentario);
    }

    /**
     * obtenemos Comentario por id
     * @param id el id del Comentario buscada
     * @return el Comentario encontrado, sino la encuentra devuelve null
     */
    public Comentario getComentarioById(Long id){
        return comentarioRepository.findById(id).orElse(null);
    }

    /**
     * obtenemos listado de todos los Comentarios
     * @return listado con los Comentarios en base de datos
     */
    public List<Comentario> getAllComentarios(){
        return comentarioRepository.findAll();
    }

    /**
     * borra Comentario en base de datos por id
     * @param id el id del Comentario a borrar
     */
    public void deleteComentarioById(Long id){
        comentarioRepository.deleteById(id);
    }
}
