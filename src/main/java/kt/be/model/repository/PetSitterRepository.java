package kt.be.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kt.be.model.members.PetSitterMember;

@Repository
public interface PetSitterRepository extends JpaRepository<PetSitterMember, Long> {
    Optional<PetSitterMember> findByPetSitterId(Long petSitterId);
    Optional<PetSitterMember> findByUserId(Long userId);
}
