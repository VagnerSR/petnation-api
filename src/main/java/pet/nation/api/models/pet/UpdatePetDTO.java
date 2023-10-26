package pet.nation.api.models.pet;

import jakarta.validation.constraints.NotNull;

public record UpdatePetDTO(
        @NotNull
        Long id,

        String imageSource,

        String sex,

        String name,

        String petType,

        String petBreed,

        String petSize,

        String age
    ) {
}
