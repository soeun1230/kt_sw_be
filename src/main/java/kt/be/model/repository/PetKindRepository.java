package kt.be.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kt.be.model.members.PetKindCodeMember;

public interface  PetKindRepository extends JpaRepository<PetKindCodeMember, Long>{
    Optional<PetKindCodeMember> findByPetKindCodeId(Long petKindCodeId);
    Optional<PetKindCodeMember> findByCode(Integer code);
    List<PetKindCodeMember> findAllByCodeGroup(Long codeGroup);
}