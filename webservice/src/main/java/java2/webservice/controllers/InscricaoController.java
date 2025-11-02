package java2.webservice.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java2.webservice.models.Inscricao;
import java2.webservice.repository.InscricaoRepo;

@RestController
@RequestMapping("/mackenzie/inscricoes")
public class InscricaoController {

    @Autowired
    private InscricaoRepo inscricaoRepo;

    @PostMapping
    public Inscricao criar(@RequestBody Inscricao i) {
        return inscricaoRepo.save(i);
    }

    @GetMapping
    public Iterable<Inscricao> consultar() {
        return inscricaoRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Inscricao> consultarPorId(@PathVariable long id) {
        return inscricaoRepo.findById(id);
    }

    @PutMapping("/{id}")
    public Inscricao atualizar(@PathVariable long id, @RequestBody Inscricao i) {
        Optional<Inscricao> existente = inscricaoRepo.findById(id);
        if (existente.isPresent()) {
            Inscricao inscricaoAtual = existente.get();
            inscricaoAtual.setDataInscricao(i.getDataInscricao()); 
            inscricaoAtual.setStatus(i.getStatus());
            inscricaoAtual.setMensagemApresentacao(i.getMensagemApresentacao());
            inscricaoAtual.setEstudante(i.getEstudante());
            inscricaoAtual.setVaga(i.getVaga());
            return inscricaoRepo.save(inscricaoAtual);
        } else {
            i.setId(id);
            return inscricaoRepo.save(i);
        }
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable long id) {
        if (inscricaoRepo.existsById(id)) {
            inscricaoRepo.deleteById(id);
            return "Inscrição com ID " + id + " removida com sucesso.";
        } else {
            return "Inscrição com ID " + id + " não encontrada.";
        }
    }
}