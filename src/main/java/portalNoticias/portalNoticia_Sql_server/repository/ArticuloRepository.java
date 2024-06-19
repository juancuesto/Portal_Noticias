package portalNoticias.portalNoticia_Sql_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portalNoticias.portalNoticia_Sql_server.entity.Articulo;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo,Long> {
}
