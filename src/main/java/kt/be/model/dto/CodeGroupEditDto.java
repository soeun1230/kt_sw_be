package kt.be.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CodeGroupEditDto {
    public Long codeGroup;
    public String codeGroupExp;
}
