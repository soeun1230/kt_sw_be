package kt.be.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kt.be.model.members.CodeTypeMember;

public interface  CodeTypeRepository extends JpaRepository<CodeTypeMember, Long>{
    Optional<CodeTypeMember> findByCodeTypeId(Long codeTypeId);
    Optional<CodeTypeMember> findByCodeGroup(Long code);
}
