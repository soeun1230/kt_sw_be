package kt.be.model.dto;

import kt.be.model.members.UserMember;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PetSitterDto {
    private Long petSitterId;
    private UserMember user;
    private String address;
    private Integer possiblePet;
    private String possibleTime;
    private Long costPerHour;
    private String info;
    private String workExp;
    private byte[] SitterImage;
    private byte[] cert;
    private Integer service;
    private Integer possibleSize;

}
