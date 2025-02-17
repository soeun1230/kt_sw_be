package kt.be.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PaymentDto {
    public Long userId;

    public Integer cost;

    public Long serviceId;

    public String date;
}
