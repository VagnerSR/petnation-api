package pet.nation.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.nation.api.models.pet.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
