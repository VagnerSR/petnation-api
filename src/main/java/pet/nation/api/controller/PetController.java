package pet.nation.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pet.nation.api.models.pet.Pet;
import pet.nation.api.models.pet.PetDTO;
import pet.nation.api.models.pet.UpdatePetDTO;
import pet.nation.api.repository.PetRepository;

@RestController
@RequestMapping("/api/v1/pet")
public class PetController {

    @Autowired
    private PetRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid PetDTO json) {
        repository.save(new Pet(json));
    }

    @GetMapping
    public Page<Pet> getPets(@PageableDefault(size = 9) Pageable pageable) {
        return repository.findAll(pageable);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid UpdatePetDTO json) {
        Pet pet = repository.getReferenceById(json.id());
        pet.updatePet(json);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
