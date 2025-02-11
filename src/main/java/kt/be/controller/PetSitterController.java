package kt.be.controller;

import kt.be.model.dto.PetSitterDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PetSitterController {

    @PostMapping("/api/user/apply/petsitter")
    public Map<String, String> applyPetSitter(@RequestBody PetSitterDto petSitterDto){

    }
}
