package pet.nation.api.models.pet;

public record PetDetailDTO(
        Long id,
        String imageSource,
        String sex,
        String name,
        PetType petType,
        PetBreed petBreed,
        String petSize,
        String age,
        Long userId,
        String userName
    ) {

    public PetDetailDTO(Pet pet) {
        this(
                pet.getId(),
                pet.getImageSource(),
                pet.getSex(),
                pet.getName(),
                pet.getPetType(),
                pet.getPetBreed(),
                pet.getPetSize(),
                pet.getAge(),
                pet.getUserId(),
                pet.getUserName()
        );
    }
}
