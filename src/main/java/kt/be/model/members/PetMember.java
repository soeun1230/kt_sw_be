package kt.be.model.members;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="pet")
public class PetMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 자동 생성
    public Long petId;

    @Column
    public String petName;

    @Column
    public String petKind;

    @Column
    public Integer petAge;

    @Column
    public byte[] petPic;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName="userId")
    @JsonBackReference
    public UserMember user;
}
