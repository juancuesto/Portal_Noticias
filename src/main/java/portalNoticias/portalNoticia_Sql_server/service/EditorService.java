package portalNoticias.portalNoticia_Sql_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portalNoticias.portalNoticia_Sql_server.entity.Editor;
import portalNoticias.portalNoticia_Sql_server.repository.EditorRepository;

import java.util.List;

@Service
public class EditorService {
    @Autowired
    private EditorRepository editorRepository;

    /**
     * Guardar un V nueva en base de datos
     * @param editor el Editor a guardar
     * @return el Editor guardado
     */
    public Editor crearEditor(Editor editor){
        return editorRepository.save(editor);
    }

    /**
     * obtenemos Editor por id
     * @param id el id del Editor buscada
     * @return el Editor encontrado, sino la encuentra devuelve null
     */
    public Editor getEditorById(Long id){
        return editorRepository.findById(id).orElse(null);
    }

    /**
     * obtenemos listado de todos los Editores
     * @return listado con los Editores en base de datos
     */
    public List<Editor> getAllEditores(){
        return editorRepository.findAll();
    }

    /**
     * borra Editor en base de datos por id
     * @param id el id del Editor a borrar
     */
    public void deleteEditorById(Long id){
        editorRepository.deleteById(id);
    }
}
