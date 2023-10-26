package pet.nation.api.models.pet;

import jakarta.validation.constraints.NotBlank;

public record PetDTO(

        String imageSource,
        @NotBlank
        String sex,
        @NotBlank
        String name,
        @NotBlank
        String petType,
        @NotBlank
        String petBreed,
        @NotBlank
        String petSize,
        @NotBlank
        String age,

        Long userId,

        String userName) {
}
