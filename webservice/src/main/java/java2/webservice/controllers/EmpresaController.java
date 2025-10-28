package java2.webservice.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.PostConstruct;
import java2.webservice.models.Empresa;
import java2.webservice.repository.EmpresaRepo;

@RestController
@RequestMapping("/mackenzie/empresas")
public class EmpresaController {

    @PostConstruct
    public void inicializarEmpresas() {
        if (empresaRepo.count() == 0) {
            empresaRepo.save(new Empresa("Empresa Alfa LTDA", "12.345.678/0001-90", "contato@empresa-alfa.com"));
            empresaRepo.save(new Empresa("Beta Comércio ME", "98.765.432/0001-10", "beta@comercio.com"));
            empresaRepo.save(new Empresa("Gamma Serviços S.A.", "11.222.333/0001-44", "servicos@gamma.com"));
            empresaRepo.save(new Empresa("Delta Engenharia", "22.333.444/0001-55", "contato@deltaeng.com"));
            empresaRepo.save(new Empresa("Epsilon Digital", "33.444.555/0001-66", "email@epsilondigital.com"));
        }
    }

    @Autowired
    private EmpresaRepo empresaRepo;

    @PostMapping
    public Empresa criar(@RequestBody Empresa e) {
        return empresaRepo.save(e);
    }

    @GetMapping
    public Iterable<Empresa> consultar() {
        return empresaRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Empresa> consultarPorId(@PathVariable long id) {
        return empresaRepo.findById(id);
    }

    @PutMapping("/{id}")
    public Empresa atualizar(@PathVariable long id, @RequestBody Empresa e) {
        Optional<Empresa> existente = empresaRepo.findById(id);
        if (existente.isPresent()) {
            Empresa empresaAtual = existente.get();
            empresaAtual.setNome(e.getNome());
            empresaAtual.setCnpj(e.getCnpj());
            empresaAtual.setEmail(e.getEmail());
            return empresaRepo.save(empresaAtual);
        } else {
            e.setId(id);
            return empresaRepo.save(e);
        }
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable long id) {
        if (empresaRepo.existsById(id)) {
            empresaRepo.deleteById(id);
            return "Empresa com ID " + id + " removida com sucesso.";
        } else {
            return "Empresa com ID " + id + " não encontrada.";
        }
    }
}
