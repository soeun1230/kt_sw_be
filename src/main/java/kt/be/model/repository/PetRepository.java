package kt.be.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kt.be.model.members.PetMember;

@Repository
public interface PetRepository extends JpaRepository<PetMember, Long>{
    Optional<PetMember> findByPetId(Long petId);

    @Query(value = "SELECT * FROM pet WHERE user_id = :userId", nativeQuery = true)
    List<PetMember> findPetsByUserIdNative(@Param("userId") Long userId);
}


