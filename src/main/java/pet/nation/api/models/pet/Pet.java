package pet.nation.api.models.pet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pets")
@Entity(name = "Pet")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageSource;
    private String sex;
    private String name;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PetType")
    private PetType petType;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PetBreed")
    private PetBreed petBreed;
    private String petSize;
    private String age;
    private Long userId;
    private String userName;

    public Pet(PetDTO json) {
        this.imageSource = json.imageSource();
        this.sex = json.sex();
        this.name = json.name();
        this.petType = new PetType(json.petType());
        this.petBreed = new PetBreed(json.petBreed(), json.petType());
        this.petSize = json.petSize();
        this.age = json.age();
        this.userId = json.userId();
        this.userName = json.userName();
    }

    public void updatePet(UpdatePetDTO json) {
        if (json.imageSource() != null) {
            this.imageSource = json.imageSource();
        }
        if (json.sex() != null) {
            this.sex = json.sex();
        }
        if (json.name() != null) {
            this.name = json.name();
        }
        if (json.petType() != null) {
            this.petType = new PetType(json.petType());
        }
        if (json.petBreed() != null) {
            this.petBreed = new PetBreed(json.petBreed(), json.petType());
        }
        if (json.petSize() != null) {
            this.petSize = json.petSize();
        }
        if (json.age() != null) {
            this.age = json.age();
        }
    }
}
