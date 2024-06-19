package portalNoticias.portalNoticia_Sql_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portalNoticias.portalNoticia_Sql_server.entity.Comentario;
@Repository
public interface ComentarioRepository extends JpaRepository<Comentario,Long> {
}
