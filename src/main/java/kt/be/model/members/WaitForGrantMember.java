package kt.be.model.members;

import jakarta.persistence.*;
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
    @Column(name = "possible_pet")
    private Integer possiblePet;
    @Column(name = "possible_time")
    private String possibleTime;
    @Column(name = "cost_per_hour")
    private Long costPerHour;
    @Column(name = "info")
    private String info;
    @Column(name = "work_exp")
    private String workExp;
    @Column(name = "sitter_image")
    private byte[] SitterImage;
    @Column(name = "cert")
    private byte[] cert;
    @Column(name = "service")
    private Integer service;
    @Column(name = "possible_size")
    private Integer possibleSize;
}
