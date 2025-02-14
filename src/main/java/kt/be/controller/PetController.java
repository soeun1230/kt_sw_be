package kt.be.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kt.be.model.dto.PetUpdateDto;
import kt.be.service.BasicUserService;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class PetController {

    private static final Logger logger = LoggerFactory.getLogger(PetController.class);
    private final BasicUserService basicUserService;

    @GetMapping("/api/users/pets")
    public ResponseEntity<Map<String, Object>> getAllPets(@RequestParam String userId) {

        Long userIdLong = Long.parseLong(userId);
        Map<String, Object> pets = basicUserService.getPets(userIdLong);
        
        return ResponseEntity.ok(pets); // 올바른 ResponseEntity 반환
    }

    @PatchMapping("/api/users/pets")
    public ResponseEntity<Map<String, Object>> deletePet(@RequestParam Long petId) {
        
        //Long petIdLong = Long.parseLong(petId);
        Map<String, Object> response = basicUserService.deletePet(petId);
        
        if (response.containsKey("error")) {
            return ResponseEntity.badRequest().body(response);
        }
        
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/api/users/pets/update")
    public ResponseEntity<Map<String, Object>> updatePet(@RequestBody PetUpdateDto request) {
        Map<String, Object> response = basicUserService.updatePet(
            request.getPetId(),
            request.getPetName(),
            request.getPetAge(),
            request.getPetKind()
        );
        
        if (response.containsKey("error")) {
            return ResponseEntity.badRequest().body(response);
        }
        
        return ResponseEntity.ok(response);
    }
    
}
