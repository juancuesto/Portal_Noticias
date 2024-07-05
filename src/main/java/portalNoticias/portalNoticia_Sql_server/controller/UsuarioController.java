package portalNoticias.portalNoticia_Sql_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import portalNoticias.portalNoticia_Sql_server.entity.Articulo;
import portalNoticias.portalNoticia_Sql_server.entity.Editor;
import portalNoticias.portalNoticia_Sql_server.entity.Usuario;
import portalNoticias.portalNoticia_Sql_server.error.ApiResponse;
import portalNoticias.portalNoticia_Sql_server.error.BadRequestExcepcion;
import portalNoticias.portalNoticia_Sql_server.error.ResourceNotFoundException;
import portalNoticias.portalNoticia_Sql_server.service.ArticuloService;
import portalNoticias.portalNoticia_Sql_server.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ArticuloService articuloService;

    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioService.crearUsuario(usuario), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable Long id) throws BadRequestExcepcion, ResourceNotFoundException {
            return new ResponseEntity<>(usuarioService.getUsuarioById(id),HttpStatus.FOUND);

    }
    @GetMapping
    public ResponseEntity<?> getAllUsuarios(){
        return new ResponseEntity<>(usuarioService.getAllUsuarios(),HttpStatus.FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarUsuario(@RequestBody Usuario usuario,@PathVariable Long id){
        Usuario usuario1=usuarioService.getUsuarioById(id);
        if (usuario1!=null){
            usuario.setId_usuario(usuario1.getId_usuario());
            return new ResponseEntity<>(usuarioService.crearUsuario(usuario),HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No se ha encontrado el Usuario a actualizar",HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuarioById(@PathVariable Long id){
        Usuario usuario=usuarioService.getUsuarioById(id);
        if (usuario!=null){
            usuarioService.deleteUsuarioById(id);
            return new ResponseEntity<>("El Usuario se ha borrado correctamente",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No se ha encontrado el Usuario a borrar",HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Anñade al usuario un articulo en la lista de articulos consultados de un usuario
     * @param articulo el articulo consultado por el usuario que se añade a su lista
     * @param id el id del usuario que hace la consulta
     * @return ResponseEntity con el codigo de rspuesta
     */
    @PutMapping("/afegirConsulta/{id}")
    public ResponseEntity<?> afegirConsultaArtuculo(@RequestBody Articulo articulo,@PathVariable Long id){
        Usuario usuario=usuarioService.getUsuarioById(id);
        if (usuario!=null){
            Articulo articulo1=articuloService.getArticuloById(articulo.getId_articulo());
            if (articulo1!=null){
                usuario.afegirArticuloConsultado(articulo);
                return new ResponseEntity<>(usuarioService.crearUsuario(usuario),HttpStatus.OK);
            }else{
                return new ResponseEntity<>("El articulo pasado por parametro no se ha encontrado",HttpStatus.NOT_FOUND);
            }
        }else {
            return new ResponseEntity<>("El usuario que hace la consulta no se ha encontrado",HttpStatus.NOT_FOUND);
        }
    }

    @ExceptionHandler(value = BadRequestExcepcion.class)
    public ResponseEntity<ApiResponse> handlerBadRequestExcepcion(BadRequestExcepcion ex,
                                                                  WebRequest webRequest) {
        ApiResponse apiResponse = new ApiResponse(ex.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundExcepcion(ResourceNotFoundException ex,
                                                                        WebRequest webRequest){
        ApiResponse apiResponse=new ApiResponse(ex.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);

    }
}
