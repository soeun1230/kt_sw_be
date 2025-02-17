package kt.be.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kt.be.model.members.PlusCodeMember;

public interface PlusRepository extends JpaRepository<PlusCodeMember, Object>{
    Optional<PlusCodeMember> findByPlusCodeId(Long plusCodeId);
    Optional<PlusCodeMember> findByCode(Integer code);
    List<PlusCodeMember> findAllByCodeGroup(Long codeGroup);
}
