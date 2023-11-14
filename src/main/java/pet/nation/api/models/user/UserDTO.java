package pet.nation.api.models.user;

public record UserDTO(
        Long id,
        String email,
        String name,
        String phoneNumber,
        Boolean isVisible,
        Boolean isVerified
    ) {

}
