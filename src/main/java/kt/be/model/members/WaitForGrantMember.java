package kt.be.model.members;

import jakarta.persistence.*;
import kt.be.model.dto.PetSitterDto;
import kt.be.model.dto.PetSitterInfoDto;
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

    @Column
    public Long userId;   //나중에 얘 코드를 가져 와서 바꿔 주면 됨

    @Column(name = "address")
    private String address;
    @Column(name = "possiblePet")
    private Integer possiblePet;
    @Column(name = "possibleTime")
    private String possibleTime;
    private Long costPerHour;
    private String info;
    private String workExp;
    private byte[] SitterImage;
    private byte[] cert;
    private Integer service;
    private Integer possibleSize;
}
