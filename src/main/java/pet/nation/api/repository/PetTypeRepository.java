package pet.nation.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pet.nation.api.models.pet.PetType;

public interface PetTypeRepository extends JpaRepository<PetType, String> {
}
