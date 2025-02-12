package kt.be.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kt.be.model.members.UserMember;

public interface UserRepository extends JpaRepository<UserMember, Long> {
    Optional<UserMember> findByEmail(String email);
    Optional<UserMember> findByUserId(Long userId);
}

