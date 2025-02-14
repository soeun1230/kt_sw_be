package kt.be.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kt.be.model.members.UserMember;

@Repository
public interface UserRepository extends JpaRepository<UserMember, Long> {
    Optional<UserMember> findByEmail(String email);
    Optional<UserMember> findByUserId(Long userId);
}

