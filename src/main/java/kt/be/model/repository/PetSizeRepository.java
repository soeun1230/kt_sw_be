package kt.be.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kt.be.model.members.PetSizeCodeMember;

public interface  PetSizeRepository extends JpaRepository<PetSizeCodeMember, Long>{
    Optional<PetSizeCodeMember> findByPetSizeId(Long petSizeId);
    Optional<PetSizeCodeMember> findByCode(Integer code);
    List<PetSizeCodeMember> findAllByCodeGroup(Long codeGroup);
}
