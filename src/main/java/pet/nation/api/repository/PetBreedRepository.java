package pet.nation.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.nation.api.models.pet.PetBreed;

public interface PetBreedRepository extends JpaRepository<PetBreed, String> {
}
