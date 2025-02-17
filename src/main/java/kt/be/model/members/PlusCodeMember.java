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

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="plus_code")
public class PlusCodeMember {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long plusCodeId;

    @Column
    public Long codeGroup;

    @Column
    public Integer code;

    @Column
    public String codeExp;

    @Column
    public String type;

}
