package kt.be.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserStatusDto {
    public Long codeGroup;

    public Integer code;

    public String userStatus;

    public String codeExp;
}
