package kt.be.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kt.be.model.dto.PetSitterEditDto;
import kt.be.model.dto.PetSitterInfoDto;
import kt.be.model.members.PetSitterMember;
import kt.be.model.members.UserMember;
import kt.be.model.repository.PetSitterRepository;
import kt.be.model.repository.UserRepository;
import kt.be.model.repository.WaitForGrantRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PetSitterService {
    private final PetSitterRepository petSitterRepository;
    private final UserRepository userRepository;
    private final WaitForGrantRepository waitForGrantRepository;

    // public Map<String, String> applyGrantToManager(PetSitterInfoDto petSitterInfo){
    //     Map<String, String> response = new HashMap<>();
    //     try{
    //         WaitForGrantMember waitForGrantMember = new WaitForGrantMember();
    //         waitForGrantMember.setService(petSitterInfo.getService());
    //         waitForGrantRepository.save(waitForGrantMember);
    //         response.put("message", "request success");
    //     }catch (Exception e){
    //         response.put("message", "request fail");
    //     }

    //     return response;
    // }

    public Map<String, Object> editPetSitter(PetSitterEditDto petSitterEditDto) {
        // 기존 PetSitterMember 찾기
        PetSitterMember petSitter = petSitterRepository.findById(petSitterEditDto.getPetSitterId())
            .orElseThrow(() -> new IllegalArgumentException("Pet Sitter not found with id: " + petSitterEditDto.getPetSitterId()));
    
        // 값이 null이 아닐 경우에만 업데이트
        if (petSitterEditDto.getService() != null) {
            petSitter.setService(petSitterEditDto.getService());
        }
        if (petSitterEditDto.getCert() != null) {
            petSitter.setCert(petSitterEditDto.getCert());
        }
        if (petSitterEditDto.getCostPerHour() != null) {
            petSitter.setCostPerHour(petSitterEditDto.getCostPerHour());
        }
        if (petSitterEditDto.getPossiblePet() != null) {
            petSitter.setPossiblePet(petSitterEditDto.getPossiblePet());
        }
        if (petSitterEditDto.getPossibleTime() != null) {
            petSitter.setPossibleTime(petSitterEditDto.getPossibleTime());
        }
        if (petSitterEditDto.getAddress() != null) {
            petSitter.setAddress(petSitterEditDto.getAddress());
        }
        if (petSitterEditDto.getInfo() != null) {
            petSitter.setInfo(petSitterEditDto.getInfo());
        }
        if (petSitterEditDto.getPossibleSize() != null) {
            petSitter.setPossibleSize(petSitterEditDto.getPossibleSize());
        }
        if (petSitterEditDto.getWorkExp() != null) {
            petSitter.setWorkExp(petSitterEditDto.getWorkExp());
        }
        if (petSitterEditDto.getSitterImage() != null) {
            petSitter.setSitterImage(petSitterEditDto.getSitterImage());
        }
    
        // 변경 사항 저장
        petSitterRepository.save(petSitter);
    
        // 응답 반환
        Map<String, Object> response = new HashMap<>();
        response.put("updatedPetSitter", petSitter);
        return response;
    }
    

    public Map<String, Object> addPetSitter(PetSitterInfoDto petSitterInfoDto){

        UserMember user = userRepository.findByUserId(Long.parseLong(petSitterInfoDto.getUserId())).get();

        user.setUserCode(1);
        userRepository.save(user);

        PetSitterMember newPetsitter = PetSitterMember.builder()
        .userId(user.getUserId())
        .service(petSitterInfoDto.getService())
        .cert(petSitterInfoDto.getCert())
        .costPerHour(petSitterInfoDto.getCostPerHour())
        .possiblePet(petSitterInfoDto.getPossiblePet())
        .possibleTime(petSitterInfoDto.getPossibleTime())
        .address(petSitterInfoDto.getAddress())
        .info(petSitterInfoDto.getInfo())
        .possibleSize(petSitterInfoDto.getPossibleSize())
        .workExp(petSitterInfoDto.getWorkExp())
        .sitterImage(petSitterInfoDto.getSitterImage())
        .build();

        petSitterRepository.save(newPetsitter);

        Map<String, Object> petSitter = new HashMap<>();
        petSitter.put("petSitter",newPetsitter);

        return petSitter;
    }

    public Map<String, Object> getPetSitterInfo(Long petSitterId){
        PetSitterMember petSitterMember = petSitterRepository.findByPetSitterId(petSitterId).get();

        Map<String, Object> petSitterInfo = new HashMap<>();

        petSitterInfo.put("petSitter",petSitterMember);

        return petSitterInfo;
    }

    public void cancelPetSitter(Long userId, Long petSitterId){
        UserMember user = userRepository.findByUserId(userId).get();
        user.setUserCode(0);
        userRepository.save(user);

        PetSitterMember petSitter = petSitterRepository.findByPetSitterId(petSitterId).get();
        petSitterRepository.delete(petSitter);
    }

    public Map<String, Object> getAllPetSitter(Long userId){
        
        List<PetSitterMember> petSitters = petSitterRepository.findAllExceptUser(userId);

        Map<String, Object> sitters = new HashMap<>();
        sitters.put("sitters",petSitters);

        return sitters;
    }
}
