package kt.be.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import jakarta.persistence.Column;
import kt.be.model.dto.ServiceDto;
import kt.be.model.members.ServiceMember;
import kt.be.model.repository.PetSitterRepository;
import kt.be.model.repository.ServiceRepository;
import kt.be.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceRegisterService {
    private final ServiceRepository serviceRepository;
    private final UserRepository userRepository;
    private final PetSitterRepository petSitterRepository;

    public Map<String, Object> ServiceRegister(ServiceDto serviceDto){
        ServiceMember newServiceMember = ServiceMember.builder()
        .cost(serviceDto.getCost())
        .status(0)
        .userId(serviceDto.getUserId())
        .petSitterId(serviceDto.getPetSitterId())
        .date(serviceDto.getDate())
        .petKind(serviceDto.getPetKind())
        .payment(false)
        .build();

        serviceRepository.save(newServiceMember);

        Map<String, Object> service = new HashMap<>();

        service.put("message", "added");
        service.put("serviceId", newServiceMember.getServiceId());

        return service;
    }

    public Map<String, Object> ServiceOk(Long serviceId){
        ServiceMember serviceMember = serviceRepository.findByServiceId(serviceId).get();
        serviceMember.setStatus(1);
        serviceRepository.save(serviceMember);
        Map<String, Object> updated = new HashMap<>();

        updated.put("message", "updated");

        return updated;
    }

    public Map<String, Object> showServiceForUser(Long userId){
        List<ServiceMember> services = serviceRepository.findAllByUserId(userId);

        List<ServiceMember> registered = new ArrayList<>();
        List<ServiceMember> notRegistered = new ArrayList<>();

        for(ServiceMember service : services){
            if(service.getStatus()==0){
                notRegistered.add(service);
            }
            else{
                registered.add(service);
            }
        }

        Map<String, Object> service = new HashMap<>();
        service.put("registered",registered);
        service.put("notRegistered",notRegistered);

        return service;
        
    }

    public Map<String, Object> showServiceForPetSitter(Long petSitterId){
        List<ServiceMember> services = serviceRepository.findAllByPetSitterId(petSitterId);

        List<ServiceMember> registered = new ArrayList<>();
        List<ServiceMember> notRegistered = new ArrayList<>();

        for(ServiceMember service : services){
            if(service.getStatus()==0){
                notRegistered.add(service);
            }
            else{
                registered.add(service);
            }
        }

        Map<String, Object> service = new HashMap<>();
        service.put("registered",registered);
        service.put("notRegistered",notRegistered);

        return service;
    }

    public Map<String, Object> paymentCheck(Long serviceId){
        ServiceMember serviceMember = serviceRepository.findByServiceId(serviceId).get();
        serviceMember.setPayment(true);
        serviceRepository.save(serviceMember);

        Map<String, Object> service = new HashMap<>();
        service.put("message", "pay");

        return service;
    }

}
