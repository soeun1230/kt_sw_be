package kt.be.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PetDto {
    private Long userId;
    private String petName;
    private  String petKind;
    private Integer petAge;
    private byte[] petPic;
}
