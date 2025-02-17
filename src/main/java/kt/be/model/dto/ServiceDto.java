package kt.be.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ServiceDto {
    public Integer status;

    public Long userId;

    public Long petSitterId;

    public String date;

    public String petKind;

    public Long cost;
}
