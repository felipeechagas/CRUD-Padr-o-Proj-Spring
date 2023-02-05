package one.digitalInnovation.labpadroesprojetospring.repository;

import one.digitalInnovation.labpadroesprojetospring.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
