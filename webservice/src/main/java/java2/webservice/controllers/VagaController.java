package java2.webservice.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java2.webservice.models.Vaga;
import java2.webservice.repository.VagaRepo;

@RestController
@RequestMapping("/mackenzie/vagas")
public class VagaController {

        @Autowired
        private VagaRepo vagaRepo;

        @PostMapping
        public Vaga criar(@RequestBody Vaga v) {
                return vagaRepo.save(v);
        }

        @GetMapping
        public Iterable<Vaga> consultar() {
                return vagaRepo.findAll();
        }

        @GetMapping("/{id}")
        public Optional<Vaga> consultarPorId(@PathVariable long id) {
                return vagaRepo.findById(id);
        }

        @PutMapping("/{id}")
        public Vaga atualizar(@PathVariable long id, @RequestBody Vaga v) {
                Optional<Vaga> existente = vagaRepo.findById(id);
                if (existente.isPresent()) {
                        Vaga vagaAtual = existente.get();
                        vagaAtual.setTitulo(v.getTitulo());
                        vagaAtual.setDescricao(v.getDescricao());
                        vagaAtual.setPublicacao(v.getPublicacao());
                        vagaAtual.setAtivo(v.getAtivo());
                        vagaAtual.setEmpresa(v.getEmpresa());
                        return vagaRepo.save(vagaAtual);
                } else {
                        v.setId(id);
                        return vagaRepo.save(v);
                }
        }

        @DeleteMapping("/{id}")
        public String deletar(@PathVariable long id) {
                if (vagaRepo.existsById(id)) {
                        vagaRepo.deleteById(id);
                        return "Vaga com ID " + id + " removida com sucesso.";
                } else {
                        return "Vaga com ID " + id + " não encontrada.";
                }
        }
}