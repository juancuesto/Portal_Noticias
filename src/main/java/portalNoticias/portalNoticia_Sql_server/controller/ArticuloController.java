package portalNoticias.portalNoticia_Sql_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portalNoticias.portalNoticia_Sql_server.entity.Articulo;
import portalNoticias.portalNoticia_Sql_server.service.ArticuloService;

@RestController
@RequestMapping("/articulos")
public class ArticuloController {
    @Autowired
    private ArticuloService articuloService;

    @PostMapping
    public ResponseEntity<?> crearArticulo(@RequestBody Articulo articulo){
        return new ResponseEntity<>(articuloService.crearArticulo(articulo), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getArticuloById(@PathVariable Long id){
        Articulo articulo=articuloService.getArticuloById(id);
        if (articulo!=null){
            return new ResponseEntity<>(articulo,HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>("No se ha encontrado el Articulo buscado",HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<?> getAllArticulos(){
        return new ResponseEntity<>(articuloService.getAllArticulos(),HttpStatus.FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarArticulo(@RequestBody Articulo articulo,@PathVariable Long id){
        Articulo articulo1=articuloService.getArticuloById(id);
        if (articulo1!=null){
            articulo.setId_articulo(articulo1.getId_articulo());
            return new ResponseEntity<>(articuloService.crearArticulo(articulo),HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No se ha encontrado el Articulo a actualizar",HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArticuloById(@PathVariable Long id){
        Articulo articulo=articuloService.getArticuloById(id);
        if (articulo!=null){
            articuloService.deleteArticuloById(id);
            return new ResponseEntity<>("El articulo se ha borrado correctamente",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No se ha encontrado el Articulo a borrar",HttpStatus.NOT_FOUND);
        }
    }
}
