package kt.be.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PetKindDto {
    public Long codeGroup;

    public Integer code;

    public String petKind;

    public String codeExp;
}
