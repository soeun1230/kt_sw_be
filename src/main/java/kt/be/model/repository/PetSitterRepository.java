package kt.be.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kt.be.model.members.PetSitterMember;

@Repository
public interface PetSitterRepository extends JpaRepository<PetSitterMember, Long> {
    Optional<PetSitterMember> findByPetSitterId(Long petSitterId);
    Optional<PetSitterMember> findByUserId(Long userId);

    @Query(value = "SELECT * FROM pet_sitter WHERE user_id != :userId", nativeQuery = true)
    List<PetSitterMember> findAllExceptUser(@Param("userId") Long userId);
}
