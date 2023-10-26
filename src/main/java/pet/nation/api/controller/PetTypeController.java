package pet.nation.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pet.nation.api.models.pet.PetType;
import pet.nation.api.repository.PetTypeRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pet-types")
public class PetTypeController {
    @Autowired
    private PetTypeRepository petTypeRepository;

    @GetMapping
    public List<PetType> getPetTypes() {
        return petTypeRepository.findAll();
    }
}
