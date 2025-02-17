package kt.be.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kt.be.model.dto.PaymentDto;
import kt.be.model.members.PaymentMember;
import kt.be.model.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public Map<String, Object> getAllPayment(Long userId){
        List<PaymentMember> payments = paymentRepository.findAllByUserId(userId);

        Map<String, Object> userPayment = new HashMap<>();

        userPayment.put("payment", payments);

        return userPayment;
    }
    
    public Map<String, Object> addPaymentRecord(PaymentDto paymentDto){
        PaymentMember paymentMember = PaymentMember.builder()
        .cost(paymentDto.getCost())
        .date(paymentDto.getDate())
        .userId(paymentDto.getUserId())
        .serviceId(paymentDto.getServiceId())
        .build();

        paymentRepository.save(paymentMember);

        Map<String, Object> payment = new HashMap<>();

        payment.put("message", "success");

        return payment;
    }
}
