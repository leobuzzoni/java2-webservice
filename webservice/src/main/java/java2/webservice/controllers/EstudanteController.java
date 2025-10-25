package java2.webservice.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import java2.webservice.models.Estudante;

@RestController
public class EstudanteController {
    private List<Estudante> estudantes;

    public EstudanteController() {
        estudantes = new ArrayList<>();
        estudantes.add(new Estudante(1, "Ana Paula Souza", "ana.souza@email.com", "2002-03-15", 2020));
        estudantes.add(new Estudante(2, "Carlos Henrique Lima", "carlos.lima@email.com", "2001-10-22", 2019));
        estudantes.add(new Estudante(3, "Fernanda Oliveira", "fernanda.oliveira@email.com", "2003-07-05", 2021));
        estudantes.add(new Estudante(4, "Lucas Pereira", "lucas.pereira@email.com", "2002-04-11", 2020));
        estudantes.add(new Estudante(5, "Gabriela Martins", "gabriela.martins@email.com", "2001-12-25", 2019));
        estudantes.add(new Estudante(6, "Rafael Costa", "rafael.costa@email.com", "2000-09-13", 2018));
        estudantes.add(new Estudante(7, "Juliana Silva", "juliana.silva@email.com", "2002-06-18", 2020));
        estudantes.add(new Estudante(8, "Marcos VinÃcius", "marcos.vinicius@email.com", "2003-01-30", 2021));
        estudantes.add(new Estudante(9, "Camila Azevedo", "camila.azevedo@email.com", "2001-11-08", 2019));
        estudantes.add(new Estudante(10, "Felipe Cardoso", "felipe.cardoso@email.com", "2000-08-27", 2018));
    }

    @GetMapping("/mackenzie/estudantes")
    Iterable<Estudante> getEstudantes() {
        return this.estudantes;
    }

    @GetMapping("/mackenzie/estudantes/{id}")
    Optional<Estudante> getEstudante(@PathVariable long id) {
        for (Estudante e : estudantes) {
            if (e.getId() == id) {
                return Optional.of(e);
            }
        }
        return Optional.empty();
    }

    @PostMapping("/mackenzie/estudantes")
    Estudante createEstudante(@RequestBody Estudante e) {
        long maxId = 1;
        for (Estudante est : estudantes) {
            if (est.getId() > maxId) {
                maxId = est.getId();
            }
        }
        e.setId(maxId + 1);
        estudantes.add(e);
        return e;
    }

    @PutMapping("/mackenzie/estudantes/{id}")
    Optional<Estudante> updateEstudante(@RequestBody Estudante estudanteRequest, @PathVariable long id) {
        Optional<Estudante> opt = this.getEstudante(id);
        if (opt.isPresent()) {
            Estudante estudante = opt.get();
            estudante.setNome(estudanteRequest.getNome());
            estudante.setEmail(estudanteRequest.getEmail());
            estudante.setNascimento(estudanteRequest.getNascimento());
            estudante.setAnoIngresso(estudanteRequest.getAnoIngresso());
        }

        return opt;
    }

    @DeleteMapping("/mackenzie/estudantes/{id}")
    void deleteEstudante(@PathVariable long id) {
        estudantes.removeIf(e -> e.getId() == id);
    }
}