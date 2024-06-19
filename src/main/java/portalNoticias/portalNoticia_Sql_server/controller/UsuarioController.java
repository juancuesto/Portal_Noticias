package portalNoticias.portalNoticia_Sql_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portalNoticias.portalNoticia_Sql_server.entity.Editor;
import portalNoticias.portalNoticia_Sql_server.entity.Usuario;
import portalNoticias.portalNoticia_Sql_server.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioService.crearUsuario(usuario), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable Long id){
        Usuario usuario=usuarioService.getUsuarioById(id);
        if (usuario!=null){
            return new ResponseEntity<>(usuario,HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>("No se ha encontrado el Usuario buscado",HttpStatus.NOT_FOUND);
        }
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
}
