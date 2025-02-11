package kt.be.model.repository;

import kt.be.model.members.ShopCartMember;
import kt.be.model.members.UserMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShopCartRepository extends JpaRepository<ShopCartMember, Long> {
    Optional<ShopCartMember> findByUser(UserMember userMember);
}
