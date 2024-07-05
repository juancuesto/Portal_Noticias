package portalNoticias.portalNoticia_Sql_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portalNoticias.portalNoticia_Sql_server.entity.Articulo;
import portalNoticias.portalNoticia_Sql_server.entity.Usuario;
import portalNoticias.portalNoticia_Sql_server.error.BadRequestExcepcion;
import portalNoticias.portalNoticia_Sql_server.error.ResourceNotFoundException;
import portalNoticias.portalNoticia_Sql_server.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;


    /**
     * Guardar un Usuario nuevo en base de datos
     * @param usuario el Usuario a guardar
     * @return el Usuario guardado
     */
    public Usuario crearUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    /**
     * obtenemos Usuario por id
     * @param id el id del Usuario buscada
     * @return el Usuario encontrado, sino la encuentra devuelve null
     */
    public Usuario getUsuarioById(Long id)throws BadRequestExcepcion, ResourceNotFoundException {
        Optional<Usuario> usuarioOptional=usuarioRepository.findById(id);
        if (usuarioOptional.isEmpty()){
            throw  new ResourceNotFoundException(" /usuarios ");
        }
        if (!(id instanceof  Long)){
            throw new BadRequestExcepcion("el formato del id es incorrecto");
        }
        if(id==null){
            throw new BadRequestExcepcion("Debes poner el id a buscar");
        }
        return usuarioRepository.findById(id).orElse(null);
    }

    /**
     * obtenemos listado de todos los Usuarios
     * @return listado con los Usuarios en base de datos
     */
    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    /**
     * borra Usuario en base de datos por id
     * @param id el id del Usuario a borrar
     */
    public void deleteUsuarioById(Long id){
        usuarioRepository.deleteById(id);
    }

    public Usuario afegirArticuloConsultado(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }
}
