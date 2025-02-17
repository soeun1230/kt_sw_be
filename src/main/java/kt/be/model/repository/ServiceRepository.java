package kt.be.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kt.be.model.members.ServiceMember;

public interface ServiceRepository extends JpaRepository<ServiceMember, Object>{
    Optional<ServiceMember> findByServiceId(Long serviceId);
    Optional<ServiceMember> findByStatus(Integer status);
    List<ServiceMember> findAllByStatus(Integer status);
    List<ServiceMember> findAllByUserId(Long userId);
    List<ServiceMember> findAllByPetSitterId(Long petSitterId);
}
