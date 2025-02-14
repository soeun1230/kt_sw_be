package kt.be.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PetUpdateDto {
    private Long petId;
    private String petName;
    private String petKind;
    private Integer petAge;
} 