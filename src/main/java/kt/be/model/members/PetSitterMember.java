package kt.be.model.members;

import java.util.List;

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
@Table(name = "pet_sitter")
public class PetSitterMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 자동 생성
    private Long petSitterId;

    // @OneToOne
    // @JoinColumn(name = "userId", referencedColumnName="userId")
    @Column(name="userId")
    public Long userId;

    @Column(name="address")
    public String address;

    @Column(name ="possible_pet")
    public List<String> possiblePet;

    @Column(name="possible_time")
    public String possibleTime;

    @Column(name = "cost_per_hour")
    public Long costPerHour;

    @Column(name = "info")
    public String info;

    @Column(name = "work_exp")
    public String workExp;

    @Column(name = "sitter_image")
    public byte[] sitterImage;

    @Column(name = "cert")
    public byte[] cert;

    @Column(name = "service")
    public String service;

    @Column(name="possible_size")
    public String possibleSize;
}
