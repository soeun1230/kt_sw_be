package kt.be.model.members;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "shop_cart")
public class ShopCartMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 자동 생성
    private Long shopCartId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", unique = true)
    public UserMember user;

}
