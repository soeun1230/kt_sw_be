package kt.be.model.members;

import jakarta.persistence.*;
import kt.be.model.dto.PetSitterDto;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "wait_for_grant")
public class WaitForGrantMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long waitId;

    @OneToOne
    @JoinColumn(name = "userId")
    public UserMember user;   //나중에 얘 코드를 가져 와서 바꿔 주면 됨

    @Column(name = "petSitterInfo")
    public PetSitterDto petSitterInfo;
}
