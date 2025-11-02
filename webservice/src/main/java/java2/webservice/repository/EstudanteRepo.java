package java2.webservice.repository;

import org.springframework.data.repository.CrudRepository;

import java2.webservice.models.Estudante;

public interface EstudanteRepo
                extends CrudRepository<Estudante, Long> {

}