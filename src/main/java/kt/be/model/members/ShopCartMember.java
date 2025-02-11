package kt.be.model.members;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "shop_cart")
public class ShopCartMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 자동 생성
    private Long shopCartId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", unique = true)
    public UserMember user;

}
