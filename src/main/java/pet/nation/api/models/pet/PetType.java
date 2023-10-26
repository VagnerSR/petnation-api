package pet.nation.api.models.pet;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Table(name = "PetTypes")
@Entity(name = "PetType")
@NoArgsConstructor
@AllArgsConstructor
public class PetType {

    @Id
    private String petType;


}
