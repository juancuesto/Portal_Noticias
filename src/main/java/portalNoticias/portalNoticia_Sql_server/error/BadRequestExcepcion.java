package portalNoticias.portalNoticia_Sql_server.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestExcepcion extends RuntimeException{
    private String mensaje;
    public BadRequestExcepcion(String message) {
        this.mensaje=message;
    }
}
