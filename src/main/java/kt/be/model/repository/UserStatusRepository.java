package kt.be.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kt.be.model.members.UserStatusCodeMember;

public interface UserStatusRepository extends JpaRepository<UserStatusCodeMember, Long>{
    Optional<UserStatusCodeMember> findByUserStatusId(Long userStatusId);
    Optional<UserStatusCodeMember> findByCode(Integer code);
    List<UserStatusCodeMember> findAllByCodeGroup(Long codeGroup);
}
