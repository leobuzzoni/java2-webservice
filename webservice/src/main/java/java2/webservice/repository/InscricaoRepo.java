package java2.webservice.repository;

import org.springframework.data.repository.CrudRepository;
import java2.webservice.models.Inscricao;

public interface InscricaoRepo extends CrudRepository<Inscricao, Long> {
}