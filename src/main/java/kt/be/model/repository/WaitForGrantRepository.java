package kt.be.model.repository;

import kt.be.model.members.WaitForGrantMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WaitForGrantRepository extends JpaRepository<WaitForGrantMember, Long> {
    Optional<WaitForGrantMember> findByWaitId(Long waitId);
}
