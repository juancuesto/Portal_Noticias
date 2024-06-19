package portalNoticias.portalNoticia_Sql_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portalNoticias.portalNoticia_Sql_server.entity.Categoria;
import portalNoticias.portalNoticia_Sql_server.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;


    @PostMapping
    public ResponseEntity<?> crearCategoria(@RequestBody Categoria categoria){
        return new ResponseEntity<>(categoriaService.crearCategoria(categoria), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoriaById(@PathVariable Long id){
        Categoria categoria=categoriaService.getCategoriaById(id);
        if (categoria!=null){
            return new ResponseEntity<>(categoria,HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>("No se ha encontrado la categoria buscada",HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<?> getAllcategorias(){
        return new ResponseEntity<>(categoriaService.getAllCategorias(),HttpStatus.FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarCategoria(@RequestBody Categoria categoria,@PathVariable Long id){
        Categoria categoria1=categoriaService.getCategoriaById(id);
        if (categoria1!=null){
            categoria.setId_categoria(categoria1.getId_categoria());
            return new ResponseEntity<>(categoriaService.crearCategoria(categoria),HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No se ha encontrado la categoria1 a actualizar",HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoria1ById(@PathVariable Long id){
        Categoria categoria=categoriaService.getCategoriaById(id);
        if (categoria!=null){
            categoriaService.deleteCategoriaById(id);
            return new ResponseEntity<>("la categoria se ha borrado correctamente",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No se ha encontrado la categoria a borrar",HttpStatus.NOT_FOUND);
        }
    }
}
