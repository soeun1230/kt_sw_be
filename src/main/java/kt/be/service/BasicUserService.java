package kt.be.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kt.be.model.members.PetMember;
import kt.be.model.members.UserMember;
import kt.be.model.repository.PetRepository;
import kt.be.model.repository.UserRepository;

@Service
//@RequiredArgsConstructor
public class BasicUserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final PetRepository petRepository;
    private static final Logger logger = LoggerFactory.getLogger(BasicUserService.class);

    public BasicUserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
    PetRepository petRepository){
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.petRepository = petRepository;
    }

    @Transactional
    public Map<String, String> userWithdraw(Long userId){
        Map<String, String> userDelete = new HashMap<>();
        UserMember userMember = userRepository.findByUserId(userId).get();
        userRepository.delete(userMember);

        userDelete.put("message","회원 탈퇴 했습니다");

        return userDelete;
    }
    
    public Map<String, Object> updateUser(Long userId, String pw, String phone, String name){
        Map<String, Object> updatedInfo = new HashMap<>();
        UserMember userMember = userRepository.findByUserId(userId).get();

        if(pw!=null){
            userMember.setPassword(pw);
            userMember.setPassword(passwordEncoder.encode(pw));
        }
        if(name!=null){
            userMember.setUserName(name);
        }
        if(phone!=null){
            userMember.setUserPhone(phone);
        }
        userRepository.save(userMember);

        updatedInfo.put("userId",userMember.getUserId());
        updatedInfo.put("name",userMember.getUsername());
        
        return updatedInfo;
    }
    
    public Map<String, Object> getUserInfo(Long userId){
        Map<String, Object> userInfo = new HashMap<>();
        
        try {
            Optional<UserMember> optionalUser = userRepository.findByUserId(userId);
            UserMember userMember = optionalUser.orElseThrow(() -> 
                new NoSuchElementException("User not found with ID: " + userId));

            logger.info("userName: {}", userMember.getUsername());
            userInfo.put("name",userMember.userName);
            userInfo.put("email", userMember.getEmail());
            userInfo.put("phone", userMember.getUserPhone());
            userInfo.put("userCode", userMember.getUserCode());
        } catch (Exception e) {
            userInfo.put("error",e.getMessage());
        }
        
        return userInfo;
    }

    public Map<String, Object> addPet(String userId, Integer age, String kind, String name, byte[] pic){
        Long userIdLong = Long.parseLong(userId);
        UserMember user = userRepository.findByUserId(userIdLong).get();
        PetMember pet = PetMember.builder()
        .petAge(age)
        .petKind(kind)
        .petName(name)
        .petPic(pic)
        .user(user)
        .build();

        petRepository.save(pet);
        Map<String, Object> petInfo = new HashMap<>();
        petInfo.put("message", "add pet");

        return petInfo;
    }

    public Map<String, Object> getPets(Long userId){
        Map<String, Object> petInfo = new HashMap<>();
        //UserMember user = userRepository.findByUserId(userId).get();

        //logger.info("petpetpet "+userId);
        List<PetMember> pets = petRepository.findPetsByUserIdNative(userId);
        
        petInfo.put("message", pets);

        return petInfo;
    }

    public Map<String, Object> deletePet(Long petId) {
        Map<String, Object> response = new HashMap<>();

        logger.info("inside service "+petId);
        
        try {
            Optional<PetMember> optionalPet = petRepository.findById(petId);
            
            if (optionalPet.isEmpty()) {
                response.put("error", "해당 반려동물을 찾을 수 없습니다.");
                return response;
            }
            
            PetMember pet = optionalPet.get();
        
            
            petRepository.delete(pet);
            response.put("message", "반려동물이 삭제되었습니다.");
            
        } catch (Exception e) {
            response.put("error", "반려동물 삭제 중 오류가 발생했습니다.");
        }
        
        return response;
    }

    public Map<String, Object> updatePet(Long petId, String petName, Integer petAge, String petKind) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            Optional<PetMember> optionalPet = petRepository.findById(petId);
            
            if (optionalPet.isEmpty()) {
                response.put("error", "해당 반려동물을 찾을 수 없습니다.");
                return response;
            }
            
            PetMember pet = optionalPet.get();
            
            // 정보 업데이트
            if (petName != null) pet.setPetName(petName);
            if (petAge != null) pet.setPetAge(petAge);
            if (petKind != null) pet.setPetKind(petKind);
            
            petRepository.save(pet);
            response.put("message", "반려동물 정보가 수정되었습니다.");
            
        } catch (Exception e) {
            response.put("error", "반려동물 정보 수정 중 오류가 발생했습니다.");
        }
        
        return response;
    }

}
