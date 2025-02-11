package kt.be.model.repository;

import kt.be.model.members.UserMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserMember, Long> {
    Optional<UserMember> findByEmail(String email);
}

