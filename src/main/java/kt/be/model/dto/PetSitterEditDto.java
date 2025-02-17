package kt.be.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PetSitterEditDto {
    private Long petSitterId;
    private String userId;
    private String address;
    private List<String> possiblePet;
    private String possibleTime;
    private Long costPerHour;
    private String info;
    private String workExp;
    private byte[] sitterImage;
    private byte[] cert;
    private String service;
    private String possibleSize;
}
