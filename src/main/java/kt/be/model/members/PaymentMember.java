package kt.be.model.members;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentMember {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long paymentId;

    @Column
    public Long userId;

    @Column
    public Integer cost;

    @Column
    public Long serviceId;

    @Column
    public String date;
}
