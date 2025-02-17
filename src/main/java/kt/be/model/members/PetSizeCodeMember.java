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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="pet_size_code")
public class PetSizeCodeMember {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long petSizeId;

    @Column
    public Long codeGroup;

    @Column
    public Integer code;

    @Column
    public String petSize;

    @Column
    public String codeExp;
}
