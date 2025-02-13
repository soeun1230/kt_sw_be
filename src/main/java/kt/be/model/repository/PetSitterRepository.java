package kt.be.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kt.be.model.members.PetSitterMember;

public interface PetSitterRepository extends JpaRepository<PetSitterMember, Long> {
    Optional<PetSitterMember> findByPetSitterId(Long petSitterId);
}
