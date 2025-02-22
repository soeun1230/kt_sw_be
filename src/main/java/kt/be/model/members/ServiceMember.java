package kt.be.model.members;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="service")
public class ServiceMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    public Long serviceId;

    @Column
    public Integer status;

    @Column
    public Long userId;

    @Column
    public Long petSitterId;

    @Column
    public String date;

    @Column
    public String petKind;

    @Column
    public Long cost;

    @Column
    public boolean payment;
}
