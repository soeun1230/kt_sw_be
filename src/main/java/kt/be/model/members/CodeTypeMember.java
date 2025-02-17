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
@Table(name="code_type")
public class CodeTypeMember {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long codeTypeId;
    
    @Column
    public Long codeGroup;

    @Column
    public String groupExp;
}