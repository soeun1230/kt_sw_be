package kt.be.service;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kt.be.model.members.UserMember;
import kt.be.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BasicUserService {
    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(BasicUserService.class);

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
    
    public Map<String, String> getUserInfo(Long userId){
        Map<String, String> userInfo = new HashMap<>();
        
        try {
            Optional<UserMember> optionalUser = userRepository.findByUserId(userId);
            UserMember userMember = optionalUser.orElseThrow(() -> 
                new NoSuchElementException("User not found with ID: " + userId));

            logger.info("userName: {}", userMember.getUsername());
            userInfo.put("name",userMember.userName);
            userInfo.put("email", userMember.getEmail());
        } catch (Exception e) {
            userInfo.put("error",e.getMessage());
        }
        
        return userInfo;
    }

}
