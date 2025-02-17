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
@Table(name="pet_kind_code")
public class PetKindCodeMember {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long petKindCodeId;

    @Column
    public Long codeGroup;

    @Column
    public Integer code;

    @Column
    public String petKind;

    @Column
    public String codeExp;
}
