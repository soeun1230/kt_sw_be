package kt.be.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kt.be.model.dto.CodeGroupEditDto;
import kt.be.model.dto.PetKindDto;
import kt.be.model.dto.PetSizeDto;
import kt.be.model.dto.UserStatusDto;
import kt.be.service.CodeService;
import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
public class CodeController {

    private final CodeService codeService;

    @GetMapping("/api/manager/codes")
    public ResponseEntity<Map<Object, Object>> getAllCodes() {
        Map<Object,Object> codes = codeService.getAllCodes();

        return ResponseEntity.ok(codes);
    }

    @PostMapping("/api/manager/codes/group")
    public ResponseEntity<Map<String, Object>> codeGroupAdd(@RequestBody CodeGroupEditDto codeGroupEditDto) {
        Map<String, Object> response = codeService.codeGroupAdd(codeGroupEditDto);
        
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/api/manager/codes/petsize")
    public ResponseEntity<Map<String, Object>> petSizeAdd(@RequestBody PetSizeDto petSizeDto) {
        Map<String, Object> response = codeService.petSizeCodeAdd(petSizeDto);
        
        return ResponseEntity.ok(response);
    }

    @PostMapping("/api/manager/codes/petkind")
    public ResponseEntity<Map<String, Object>> petKindAdd(@RequestBody PetKindDto petKindDto) {
        Map<String, Object> response = codeService.petKindCodeAdd(petKindDto);
        
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/api/manager/codes/userstatus")
    public ResponseEntity<Map<String, Object>> userStatusAdd(@RequestBody UserStatusDto userStatusDto) {
        Map<String, Object> response = codeService.userStatusCodeAdd(userStatusDto);
        
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/api/manager/codes/group/delete/{codeGroup}")
    public ResponseEntity<Map<String, Object>> codeGroupDelete(@PathVariable Long codeGroup){
        Map<String, Object> response = codeService.deleteCodeGroup(codeGroup);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/api/manager/codes/petsize/delete/{code}")
    public ResponseEntity<Map<String, Object>> petSizeCodeDelete(@PathVariable Integer code){
        Map<String, Object> response = codeService.deletePetSizeCode(code);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/api/manager/codes/petkind/delete/{code}")
    public ResponseEntity<Map<String, Object>> petKindCodeDelete(@PathVariable Integer code){
        Map<String, Object> response = codeService.deletePetKindCode(code);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/api/manager/codes/userstatus/delete/{code}")
    public ResponseEntity<Map<String, Object>> userStatusDelete(@PathVariable Integer code){
        Map<String, Object> response = codeService.deleteUserStatusCode(code);

        return ResponseEntity.ok(response);
    }
}
