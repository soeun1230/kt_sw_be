package kt.be.service;

import kt.be.model.dto.PetSitterInfoDto;
import kt.be.model.members.PetSitterMember;
import kt.be.model.members.WaitForGrantMember;
import kt.be.model.repository.PetSitterRepository;
import kt.be.model.repository.UserRepository;
import kt.be.model.repository.WaitForGrantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PetSitterService {
    private final PetSitterRepository petSitterRepository;
    private final UserRepository userRepository;
    private final WaitForGrantRepository waitForGrantRepository;

    public Map<String, String> applyGrantToManager(PetSitterInfoDto petSitterInfo){
        Map<String, String> response = new HashMap<>();
        try{
            WaitForGrantMember waitForGrantMember = new WaitForGrantMember();
            waitForGrantMember.setUser(petSitterInfo.getUserId());
            waitForGrantMember.setPetSitterInfo(petSitterInfo);
            waitForGrantRepository.save(waitForGrantMember);
            response.put("message", "request success");
        }catch (Exception e){
            response.put("message", "request fail");
        }

        return response;
    }
}
