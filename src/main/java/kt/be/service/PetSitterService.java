package kt.be.service;

import kt.be.model.dto.PetSitterDto;
import kt.be.model.members.PetSitterMember;
import kt.be.model.repository.PetSitterRepository;
import kt.be.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class PetSitterService {
    private final PetSitterRepository petSitterRepository;
    private final UserRepository userRepository;

    public Map<String, String> applyGrantToManager(PetSitterDto petSitterInfo){

    }
}
