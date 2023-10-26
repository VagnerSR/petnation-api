package pet.nation.api.models.pet;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(name = "PetBreeds")
@Entity(name = "PetBreed")
@NoArgsConstructor
@AllArgsConstructor
public class PetBreed {

    @Id
    private String petBreed;

    @ManyToOne
    @JoinColumn(name = "PetType")
    private PetType petType;

    public PetBreed(String petBreed, String petType) {
        this.petBreed = petBreed;
        this.petType = new PetType(petType);
    }
}
