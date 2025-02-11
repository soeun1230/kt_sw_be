package kt.be.controller;

import kt.be.model.dto.PetSitterInfoDto;
import kt.be.model.members.UserMember;
import kt.be.service.PetSitterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class PetSitterController {

    private final PetSitterService petSitterService;

    @PostMapping("/api/user/apply/petsitter")
    public ResponseEntity<Map<String, String>> applyPetSitter(@RequestBody PetSitterInfoDto petSitterDto){

        try {
            Map<String, String> applyGrant = petSitterService.applyGrantToManager(petSitterDto);
            return ResponseEntity.ok(applyGrant);
        }catch (Exception e){
            Map<String, String> error = new HashMap<>();
            error.put("message",e.toString());
            return ResponseEntity.badRequest().body(error);
        }
    }
}
