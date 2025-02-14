package kt.be.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kt.be.model.dto.PetDto;
import kt.be.model.dto.UserUpdateDto;
import kt.be.service.BasicUserService;
import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
public class UserController{

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
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

    @PatchMapping("/api/users/update")
    public ResponseEntity<Map<String,Object>> updateUser(@RequestBody UserUpdateDto userUpdateDto){
        Map<String, Object> update = basicUserService.updateUser(userUpdateDto.getUserId(), userUpdateDto.getPassword(), userUpdateDto.getUserPhone(), 
        userUpdateDto.getUserName());
        
        update.put("message", "유저 정보 업데이트 완료");
        return ResponseEntity.ok(update);
    }

    @PostMapping("/api/users/pets")
    public ResponseEntity<Map<String, Object>> addPet(@RequestBody PetDto request){

        Map<String, Object> petInfo = basicUserService.addPet(request.getUserId().toString(), request.getPetAge(), request.getPetKind(), request.getPetName(),
        request.getPetPic());

        return ResponseEntity.ok(petInfo);
    }

    @GetMapping("/api/users/code/{userId}")
    public ResponseEntity<Map<String,Object>> userCode(@PathVariable Long userId) {
        
        Map<String, Object> userInfo = basicUserService.getUserInfo(userId);
        

        return ResponseEntity.ok(userInfo);
    }
}

