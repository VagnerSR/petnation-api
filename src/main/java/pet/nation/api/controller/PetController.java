package pet.nation.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import pet.nation.api.models.pet.Pet;
import pet.nation.api.models.pet.PetDTO;
import pet.nation.api.models.pet.PetDetailDTO;
import pet.nation.api.models.pet.UpdatePetDTO;
import pet.nation.api.repository.PetRepository;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/pet")
public class PetController {

    @Autowired
    private PetRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<PetDetailDTO> register(
            @RequestBody @Valid PetDTO json,
            UriComponentsBuilder uriBuilder) {

        Pet pet = new Pet(json);
        repository.save(pet);

        URI uri = uriBuilder.path("/api/v1/pet/{id}").buildAndExpand(pet.getId()).toUri();

        return ResponseEntity.created(uri).body(new PetDetailDTO(pet));
    }

    @GetMapping
    public ResponseEntity<Page<Pet>> getPets(@PageableDefault(size = 9) Pageable pageable) {
        Page<Pet> page = repository.findAll(pageable);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<PetDetailDTO> getPetById(@PathVariable Long id) {
        Pet pet = repository.getReferenceById(id);

        return ResponseEntity.ok(new PetDetailDTO(pet));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<PetDetailDTO> update(@RequestBody @Valid UpdatePetDTO json) {
        Pet pet = repository.getReferenceById(json.id());
        pet.updatePet(json);

        return ResponseEntity.ok(new PetDetailDTO(pet));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
