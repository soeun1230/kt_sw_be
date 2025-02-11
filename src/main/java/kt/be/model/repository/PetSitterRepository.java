package kt.be.model.repository;

import kt.be.model.members.PetSitterMember;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface PetSitterRepository extends JpaRepository<PetSitterMember, Long> {
    Optional<PetSitterMember> findByPetSitterId(Long petSitterId);
}
