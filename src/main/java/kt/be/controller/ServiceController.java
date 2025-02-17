package kt.be.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kt.be.model.dto.ServiceDto;
import kt.be.service.ServiceRegisterService;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class ServiceController {
    private final ServiceRegisterService serviceRegisterService;

    @GetMapping("/api/users/services/{userId}")
    public ResponseEntity<Map<String,Object>> showAllServicesForUser(@PathVariable Long userId) {
        Map<String, Object> services = serviceRegisterService.showServiceForUser(userId);

        return ResponseEntity.ok(services);
    }
    
    @GetMapping("/api/petsitters/services/{petSitterId}")
    public ResponseEntity<Map<String,Object>> showAllServicesForPetSitter(@PathVariable Long petSitterId) {
        Map<String, Object> services = serviceRegisterService.showServiceForPetSitter(petSitterId);

        return ResponseEntity.ok(services);
    }

    @PostMapping("/api/users/services")
    public ResponseEntity<Map<String, Object>> addServices(@RequestBody ServiceDto serviceDto){
        Map<String, Object> service = serviceRegisterService.ServiceRegister(serviceDto);

        return ResponseEntity.ok(service);
    }

    @GetMapping("/api/petsitters/services/allow/{serviceId}")
    public ResponseEntity<Map<String, Object>> allowService(@PathVariable Long serviceId){
        Map<String, Object> service = serviceRegisterService.ServiceOk(serviceId);
        
        return ResponseEntity.ok(service);
    }

    @GetMapping("/api/petsitters/services/deny/{serviceId}")
    public ResponseEntity<Map<String, Object>> denyService(@PathVariable Long serviceId){
        Map<String, Object> service = serviceRegisterService.ServiceNo(serviceId);
        
        return ResponseEntity.ok(service);
    }
    
    @PatchMapping("/api/users/services/payment/{serviceId}")
    public ResponseEntity<Map<String, Object>> paymentCheck(@PathVariable Long serviceId){
        Map<String, Object> service = serviceRegisterService.paymentCheck(serviceId);

        return ResponseEntity.ok(service);
    }

    @PatchMapping("/api/services/delete/{serviceId}")
    public ResponseEntity<Map<String,Object>> deleteService(@PathVariable Long serviceId){
        Map<String, Object> service = serviceRegisterService.deleteService(serviceId);

        return ResponseEntity.ok(service);
    }

    @GetMapping("/api/users/payments/{userId}")
    public ResponseEntity<Map<String, Object>> getServicePay(@PathVariable Long userId){
        Map<String, Object> service = serviceRegisterService.getServicePay(userId);

        return ResponseEntity.ok(service);
    }
}
