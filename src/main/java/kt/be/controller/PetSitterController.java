package kt.be.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kt.be.model.dto.CancelPetSitterDto;
import kt.be.model.dto.PetSitterEditDto;
import kt.be.model.dto.PetSitterInfoDto;
import kt.be.service.PetSitterService;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class PetSitterController {

    private final PetSitterService petSitterService;

    // @PostMapping("/api/users/petsitters")
    // public ResponseEntity<Map<String, String>> applyPetSitter(@RequestBody PetSitterInfoDto petSitterDto){

    //     try {
    //         Map<String, String> applyGrant = petSitterService.applyGrantToManager(petSitterDto);
    //         return ResponseEntity.ok(applyGrant);
    //     }catch (Exception e){
    //         Map<String, String> error = new HashMap<>();
    //         error.put("message",e.toString());
    //         return ResponseEntity.badRequest().body(error);
    //     }
    // }

    @PostMapping("/api/petsitters/register")
    public ResponseEntity<Map<String, Object>> addPetSitter(@RequestBody PetSitterInfoDto petSitterInfoDto) {
        Map<String, Object> petSitter = petSitterService.addPetSitter(petSitterInfoDto);

        return ResponseEntity.ok(petSitter);
    }

    @GetMapping("/api/petsitters/mypet/{petSitterId}")
    public ResponseEntity<Map<String,Object>> getPetSitterInfo(@PathVariable Long petSitterId) {
        
        Map<String, Object> petSitter = petSitterService.getPetSitterInfo(petSitterId);

        return ResponseEntity.ok(petSitter);
    }
    
    @PatchMapping("/api/petsitters/mypet/cancel")
    public ResponseEntity<Map<String, String>> cancelPetSitter(@RequestBody CancelPetSitterDto cancelPetSitterDto){
        petSitterService.cancelPetSitter(cancelPetSitterDto.getUserId(), cancelPetSitterDto.getPetSitterId());
        Map<String, String> response = new HashMap<>();

        response.put("message", "canceled");

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/api/petsitters/mypet/edit")
    public ResponseEntity<Map<String, Object>> editPetSitter(@RequestBody PetSitterEditDto petSitterEditDto){
        Map<String, Object> response = petSitterService.editPetSitter(petSitterEditDto);

        response.put("message", "edited");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/api/users/petsitters/all/{userId}")
    public ResponseEntity<Map<String, Object>> getAllPetSitters(@PathVariable Long userId) {
        Map<String, Object> petSitters = petSitterService.getAllPetSitter(userId);

        return ResponseEntity.ok(petSitters);
    }
    
}
