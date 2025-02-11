package kt.be.controller;

import kt.be.model.dto.PetSitterDto;
import kt.be.model.members.UserMember;
import kt.be.service.PetSitterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class PetSitterController {

    private final PetSitterService petSitterService;

    @PostMapping("/api/user/apply/petsitter")
    public Map<String, String> applyPetSitter(@RequestBody PetSitterDto petSitterDto){
        Map<String, String> applyGrant = petSitterService.applyGrantToManager(petSitterDto);

    }
}
