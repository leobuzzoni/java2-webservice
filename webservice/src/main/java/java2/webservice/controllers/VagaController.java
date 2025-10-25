package java2.webservice.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import java2.webservice.models.Vaga;
import java2.webservice.models.Empresa;

@RestController
public class VagaController {
    private List<Vaga> vagas;

    public VagaController() {
        Empresa e1 = new Empresa(1, "Empresa Alfa LTDA", "12.345.678/0001-90", "contato@empresa-alfa.com");
        Empresa e2 = new Empresa(2, "Beta Comércio ME", "98.765.432/0001-10", "beta@comercio.com");
        Empresa e3 = new Empresa(3, "Gamma Serviços S.A.", "11.222.333/0001-44", "servicos@gamma.com");
        Empresa e4 = new Empresa(4, "Delta Engenharia", "22.333.444/0001-55", "contato@deltaeng.com");
        Empresa e5 = new Empresa(5, "Epsilon Digital", "33.444.555/0001-66", "email@epsilondigital.com");

        vagas = new ArrayList<>();
        vagas.add(new Vaga(1, "Desenvolvedor Java",
                "Atuação em projetos backend com Java e Spring. Experiência desejada em APIs REST.", "2025-10-01", true,
                e1));
        vagas.add(new Vaga(2, "Analista de Suporte Técnico",
                "Suporte a clientes, resolução de chamados e participação em treinamentos internos.", "2025-09-27",
                true, e2));
        vagas.add(new Vaga(3, "Engenheiro de Software",
                "Desenvolvimento de soluções para sistemas corporativos, integração e automação.", "2025-10-03", false,
                e3));
        vagas.add(new Vaga(4, "Analista de Dados",
                "Manipulação e análise de grandes volumes de dados. Conhecimentos de SQL e Python.", "2025-09-18", true,
                e4));
        vagas.add(new Vaga(5, "Designer Digital",
                "Criação de materiais gráficos, UX/UI e participação em campanhas de marketing.", "2025-09-30", false,
                e5));
        vagas.add(new Vaga(6, "Consultor de Projetos",
                "Elaboração e acompanhamento de projetos empresariais e treinamentos.", "2025-10-06", true, e1));
        vagas.add(new Vaga(7, "Programador Full Stack",
                "Desenvolvimento de aplicações web frontend e backend com foco em automação.", "2025-10-04", true, e2));
    }

    @GetMapping("/mackenzie/vagas")
    Iterable<Vaga> getVagas() {
        return this.vagas;
    }

    @GetMapping("/mackenzie/vagas/{id}")
    Optional<Vaga> getVaga(@PathVariable long id) {
        for (Vaga v : vagas) {
            if (v.getId() == id) {
                return Optional.of(v);
            }
        }
        return Optional.empty();
    }

    @PostMapping("/mackenzie/vagas")
    Vaga createVaga(@RequestBody Vaga v) {
        long maxId = 1;
        for (Vaga vag : vagas) {
            if (vag.getId() > maxId) {
                maxId = vag.getId();
            }
        }
        v.setId(maxId + 1);
        vagas.add(v);
        return v;
    }

    @PutMapping("/mackenzie/vagas/{id}")
    Optional<Vaga> updateVaga(@RequestBody Vaga vagaRequest, @PathVariable long id) {
        Optional<Vaga> opt = this.getVaga(id);
        if (opt.isPresent()) {
            Vaga vaga = opt.get();
            vaga.setTitulo(vagaRequest.getTitulo());
            vaga.setDescricao(vagaRequest.getDescricao());
            vaga.setPublicacao(vagaRequest.getPublicacao());
            vaga.setAtivo(vagaRequest.getAtivo());
            vaga.setEmpresa(vagaRequest.getEmpresa());
        }

        return opt;
    }

    @DeleteMapping("/mackenzie/vagas/{id}")
    void deleteVaga(@PathVariable long id) {
        vagas.removeIf(v -> v.getId() == id);
    }
}