package kt.be.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import kt.be.model.dto.UserUpdateDto;
import kt.be.model.members.UserMember;
import kt.be.service.BasicUserService;
import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
public class UserController{

    private final BasicUserService basicUserService;

    @GetMapping("/api/users/{userId}")
    public ResponseEntity<Map<String,Object>> userDetail(@PathVariable Long userId) {
        
        Map<String, Object> userInfo = basicUserService.getUserInfo(userId);
        

        return ResponseEntity.ok(userInfo);
    }
    
    @PatchMapping("/api/users/{userId}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable Long userId){
        Map<String, String> info = basicUserService.userWithdraw(userId);

        return ResponseEntity.ok(info);
    }

    @PatchMapping("/api/users/update/{userId}")
    public ResponseEntity<Map<String,Object>> updateUser(UserUpdateDto userUpdateDto){
        Map<String, Object> update = basicUserService.updateUser(userUpdateDto.getUserId(), userUpdateDto.getPassword(), userUpdateDto.getUserPhone(), 
        userUpdateDto.getUserName());

        update.put("message", "유저 정보 업데이트 완료");
        return ResponseEntity.ok(update);
    }
}

