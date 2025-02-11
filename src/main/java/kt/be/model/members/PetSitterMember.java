package kt.be.model.members;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@Table(name = "pet_sitter")
public class PetSitterMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 자동 생성
    private Long petSitterId;

    @OneToOne
    @JoinColumn(name = "userId")
    public UserMember user;

    @Column(name="address")
    public String address;

    @Column(name ="possible_pet")
    public Integer possiblePet;

    @Column(name="possible_time")
    public String possibleTime;

    @Column(name = "cost_per_hour")
    public Long costPerHour;

    @Column(name = "info")
    public String info;

    @Column(name = "work_exp")
    public String workExp;

    @Column(name = "sitter_image")
    public byte[] SitterImage;

    @Column(name = "cert")
    public byte[] cert;

    @Column(name = "service")
    public Integer service;

    @Column(name="possible_size")
    public Integer possibleSize;
}
