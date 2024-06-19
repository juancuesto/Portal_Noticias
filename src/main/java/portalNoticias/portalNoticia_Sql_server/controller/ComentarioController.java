package portalNoticias.portalNoticia_Sql_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portalNoticias.portalNoticia_Sql_server.entity.Comentario;
import portalNoticias.portalNoticia_Sql_server.service.ComentarioService;


@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;


    @PostMapping
    public ResponseEntity<?> crearComentario(@RequestBody Comentario comentario){
        return new ResponseEntity<>(comentarioService.crearComentario(comentario), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getComentarioById(@PathVariable Long id){
        Comentario comentario=comentarioService.getComentarioById(id);
        if (comentario!=null){
            return new ResponseEntity<>(comentario,HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>("No se ha encontrado el Comentario buscado",HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<?> getAllComentarios(){
        return new ResponseEntity<>(comentarioService.getAllComentarios(),HttpStatus.FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarComentario(@RequestBody Comentario comentario,@PathVariable Long id){
        Comentario comentario1=comentarioService.getComentarioById(id);
        if (comentario1!=null){
            comentario.setId_comentario(comentario1.getId_comentario());
            return new ResponseEntity<>(comentarioService.crearComentario(comentario),HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No se ha encontrado el Comentario a actualizar",HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComentarioById(@PathVariable Long id){
        Comentario comentario=comentarioService.getComentarioById(id);
        if (comentario!=null){
            comentarioService.deleteComentarioById(id);
            return new ResponseEntity<>("El Comentario se ha borrado correctamente",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No se ha encontrado el Comentario a borrar",HttpStatus.NOT_FOUND);
        }
    }
}
