package pet.nation.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pet.nation.api.models.pet.PetBreed;
import pet.nation.api.repository.PetBreedRepository;


import java.util.List;

@RestController
@RequestMapping("/api/v1/pet-breeds")
public class PetBreedController {

    @Autowired
    private PetBreedRepository petBreedRepository;

    @GetMapping
    public List<PetBreed> getPetBreeds() {
        return petBreedRepository.findAll();
    }
}
