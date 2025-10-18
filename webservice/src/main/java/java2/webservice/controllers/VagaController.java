package java2.webservice.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import java2.webservice.models.Vaga;

@RestController
public class VagaController {
    private List<Vaga> vagas;

    public VagaController() {
        vagas = new ArrayList<>();
        vagas.add(new Vaga(1, "Desenvolvedor Java", "Atuação em projetos backend com Java e Spring. Experiência desejada em APIs REST.", "2025-10-01", true, 1));
        vagas.add(new Vaga(2, "Analista de Suporte Técnico", "Suporte a clientes, resolução de chamados e participação em treinamentos internos.", "2025-09-27", true, 2));
        vagas.add(new Vaga(3, "Engenheiro de Software", "Desenvolvimento de soluções para sistemas corporativos, integração e automação.", "2025-10-03", false, 3));
        vagas.add(new Vaga(4, "Analista de Dados", "Manipulação e análise de grandes volumes de dados. Conhecimentos de SQL e Python.", "2025-09-18", true, 4));
        vagas.add(new Vaga(5, "Designer Digital", "Criação de materiais gráficos, UX/UI e participação em campanhas de marketing.", "2025-09-30", false, 5));
        vagas.add(new Vaga(6, "Consultor de Projetos", "Elaboração e acompanhamento de projetos empresariais e treinamentos.", "2025-10-06", true, 1));
        vagas.add(new Vaga(7, "Programador Full Stack", "Desenvolvimento de aplicações web frontend e backend com foco em automação.", "2025-10-04", true, 2));
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
        for (Vaga vaga : vagas) {
            if (vaga.getId() > maxId) {
                maxId = vaga.getId();
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
        }

        return opt;
    }

    @DeleteMapping("/mackenzie/vagas/{id}")
    void deleteVaga(@PathVariable long id) {
        vagas.removeIf(p -> p.getId() == id);
    };
}