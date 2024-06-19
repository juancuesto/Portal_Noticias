package portalNoticias.portalNoticia_Sql_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portalNoticias.portalNoticia_Sql_server.entity.Editor;
import portalNoticias.portalNoticia_Sql_server.service.EditorService;

@RestController
@RequestMapping("/editores")
public class EditorController {
    @Autowired
    private EditorService editorService;


    @PostMapping
    public ResponseEntity<?> crearEditor(@RequestBody Editor editor){
        return new ResponseEntity<>(editorService.crearEditor(editor), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getEditorById(@PathVariable Long id){
        Editor editor=editorService.getEditorById(id);
        if (editor!=null){
            return new ResponseEntity<>(editor,HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>("No se ha encontrado el Editor buscado",HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<?> getAllEditores(){
        return new ResponseEntity<>(editorService.getAllEditores(),HttpStatus.FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEditor(@RequestBody Editor editor,@PathVariable Long id){
        Editor editor1=editorService.getEditorById(id);
        if (editor1!=null){
            editor.setId_editor(editor1.getId_editor());
            return new ResponseEntity<>(editorService.crearEditor(editor),HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No se ha encontrado el Editor a actualizar",HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEditorById(@PathVariable Long id){
        Editor editor=editorService.getEditorById(id);
        if (editor!=null){
            editorService.deleteEditorById(id);
            return new ResponseEntity<>("El Editor se ha borrado correctamente",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No se ha encontrado el Editor a borrar",HttpStatus.NOT_FOUND);
        }
    }

}
