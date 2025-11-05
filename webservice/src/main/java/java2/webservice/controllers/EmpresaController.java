package java2.webservice.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java2.webservice.models.Empresa;
import java2.webservice.repository.EmpresaRepo;

@RestController
@RequestMapping("/mackenzie/empresas")
public class EmpresaController {

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