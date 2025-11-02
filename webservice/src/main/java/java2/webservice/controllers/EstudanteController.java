package java2.webservice.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java2.webservice.models.Estudante;
import java2.webservice.repository.EstudanteRepo;

@RestController
@RequestMapping("/mackenzie/estudantes")
public class EstudanteController {

        @Autowired
        private EstudanteRepo estudanteRepo;

        @PostMapping
        public Estudante criar(@RequestBody Estudante e) {
                return estudanteRepo.save(e);
        }

        @GetMapping
        public Iterable<Estudante> consultar() {
                return estudanteRepo.findAll();
        }

        @GetMapping("/{id}")
        public Optional<Estudante> consultarPorId(@PathVariable long id) {
                return estudanteRepo.findById(id);
        }

        @PutMapping("/{id}")
        public Estudante atualizar(@PathVariable long id, @RequestBody Estudante e) {
                Optional<Estudante> existente = estudanteRepo.findById(id);
                if (existente.isPresent()) {
                        Estudante estudanteAtual = existente.get();
                        estudanteAtual.setNome(e.getNome());
                        estudanteAtual.setEmail(e.getEmail());
                        estudanteAtual.setNascimento(e.getNascimento());
                        estudanteAtual.setAnoIngresso(e.getAnoIngresso());
                        return estudanteRepo.save(estudanteAtual);
                } else {
                        e.setId(id);
                        return estudanteRepo.save(e);
                }
        }

        @DeleteMapping("/{id}")
        public String deletar(@PathVariable long id) {
                if (estudanteRepo.existsById(id)) {
                        estudanteRepo.deleteById(id);
                        return "Estudante com ID " + id + " removido com sucesso.";
                } else {
                        return "Estudante com ID " + id + " não encontrado.";
                }
        }
}
