package java2.webservice.controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java2.webservice.models.Area;
import java2.webservice.repository.AreaRepo;

@RestController
@RequestMapping("/mackenzie/areas")
public class AreaController {

    @Autowired
    private AreaRepo areaRepo;

    @PostMapping
    public Area criar(@RequestBody Area a) {
        return areaRepo.save(a);
    }

    @GetMapping
    public Iterable<Area> consultar() {
        return areaRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Area> consultarPorId(@PathVariable long id) {
        return areaRepo.findById(id);
    }

    @PutMapping("/{id}")
    public Area atualizar(@PathVariable long id, @RequestBody Area a) {
        Optional<Area> existente = areaRepo.findById(id);
        if (existente.isPresent()) {
            Area areaAtual = existente.get();
            areaAtual.setNome(a.getNome());
            return areaRepo.save(areaAtual);
        } else {
            a.setId(id);
            return areaRepo.save(a);
        }
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable long id) {
        if (areaRepo.existsById(id)) {
            areaRepo.deleteById(id);
            return "Área com ID " + id + " removida com sucesso.";
        } else {
            return "Área com ID " + id + " não encontrada.";
        }
    }
}
