package java2.webservice.repository;

import org.springframework.data.repository.CrudRepository;

import java2.webservice.models.Empresa;

public interface EmpresaRepo
                extends CrudRepository<Empresa, Long> {

}