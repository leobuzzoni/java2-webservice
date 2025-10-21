package java2.webservice.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import java2.webservice.models.Empresa;

@RestController
public class EmpresaController {
    private List<Empresa> empresas;

    public EmpresaController() {
        empresas = new ArrayList<>();
        empresas.add(new Empresa(1, "Empresa Alfa LTDA", "12.345.678/0001-90", "contato@empresa-alfa.com"));
        empresas.add(new Empresa(2, "Beta Comércio ME", "98.765.432/0001-10", "beta@comercio.com"));
        empresas.add(new Empresa(3, "Gamma Serviços S.A.", "11.222.333/0001-44", "servicos@gamma.com"));
        empresas.add(new Empresa(4, "Delta Engenharia", "22.333.444/0001-55", "contato@deltaeng.com"));
        empresas.add(new Empresa(5, "Epsilon Digital", "33.444.555/0001-66", "email@epsilondigital.com"));
    }

    @GetMapping("/mackenzie/empresas")
    Iterable<Empresa> getEmpresas() {
        return this.empresas;
    }

    @GetMapping("/mackenzie/empresas/{id}")
    Optional<Empresa> getEmpresa(@PathVariable long id) {
        return empresas.stream().filter(e -> e.getId() == id).findFirst();
    }

    @PostMapping("/mackenzie/empresas")
    Empresa createEmpresa(@RequestBody Empresa e) {
        long maxId = empresas.stream().mapToLong(Empresa::getId).max().orElse(0);
        e.setId(maxId + 1);
        empresas.add(e);
        return e;
    }

    @PutMapping("/mackenzie/empresas/{id}")
    Optional<Empresa> updateEmpresa(@RequestBody Empresa empresaRequest, @PathVariable long id) {
        Optional<Empresa> opt = this.getEmpresa(id);
        opt.ifPresent(empresa -> {
            empresa.setNome(empresaRequest.getNome());
            empresa.setCnpj(empresaRequest.getCnpj());
            empresa.setEmail(empresaRequest.getEmail());
        });
        return opt;
    }

    @DeleteMapping("/mackenzie/empresas/{id}")
    void deleteEmpresa(@PathVariable long id) {
        empresas.removeIf(p -> p.getId() == id);
    }
}