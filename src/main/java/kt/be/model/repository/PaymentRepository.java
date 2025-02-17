package kt.be.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kt.be.model.members.PaymentMember;

public interface PaymentRepository extends JpaRepository<PaymentMember, Object>{
    Optional<PaymentMember> findByPaymentId(Long paymentId);
    List<PaymentMember> findAllByUserId(Long userId);
}
