package kt.be.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kt.be.model.dto.CodeGroupEditDto;
import kt.be.model.dto.PetKindDto;
import kt.be.model.dto.PetSizeDto;
import kt.be.model.dto.UserStatusDto;
import kt.be.model.members.CodeTypeMember;
import kt.be.model.members.PetKindCodeMember;
import kt.be.model.members.PetSizeCodeMember;
import kt.be.model.members.UserStatusCodeMember;
import kt.be.model.repository.CodeTypeRepository;
import kt.be.model.repository.PetKindRepository;
import kt.be.model.repository.PetSizeRepository;
import kt.be.model.repository.UserStatusRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CodeService {
    
    private final CodeTypeRepository codeTypeRepository;
    private final PetKindRepository petKindRepository;
    private final PetSizeRepository petSizeRepository;
    private final UserStatusRepository userStatusRepository;


    public Map<Object, Object> getAllCodes(){
        Map<Object, Object> codes = new HashMap<>();
        List<CodeTypeMember> codeTypes = codeTypeRepository.findAll();
        List<PetKindCodeMember> petKindCodes = petKindRepository.findAll();
        List<PetSizeCodeMember> petSizeCodes = petSizeRepository.findAll();
        List<UserStatusCodeMember> userStatusCodes = userStatusRepository.findAll();

        codes.put("codeTypes",codeTypes);
        codes.put("petKindCodes", petKindCodes);
        codes.put("petSizeCodes",petSizeCodes);
        codes.put("userStatusCodes",userStatusCodes);

        return codes;
    }

    public Map<String, Object> codeGroupAdd(CodeGroupEditDto codeGroupEditDto){
        Map<String, Object> res = new HashMap<>();
        Optional<CodeTypeMember> existingCodeType = codeTypeRepository.findByCodeGroup(codeGroupEditDto.getCodeGroup());

        if(existingCodeType.isEmpty()){
            CodeTypeMember newCodeTypeMember = CodeTypeMember.builder()
            .codeGroup(codeGroupEditDto.getCodeGroup())
            .groupExp(codeGroupEditDto.getCodeGroupExp())
            .build();

            codeTypeRepository.save(newCodeTypeMember);
            res.put("message", "add success");
        }
        else{
            res.put("message", "failed");
        }
        return res;
    }

    public Map<String, Object> petKindCodeAdd(PetKindDto petKindDto) {
        Map<String, Object> res = new HashMap<>();
    
        Optional<PetKindCodeMember> existingPetKind = petKindRepository.findByCode(petKindDto.getCode());
    
        if (existingPetKind.isEmpty()) {
            PetKindCodeMember newPetKindCodeMember = PetKindCodeMember.builder()
                .code(petKindDto.getCode())
                .codeExp(petKindDto.getCodeExp())
                .codeGroup(petKindDto.getCodeGroup())
                .petKind(petKindDto.getPetKind())
                .build();
    
            petKindRepository.save(newPetKindCodeMember);
    
            res.put("message", "add success");
        } else {
            res.put("message", "failed");
        }
    
        return res;
    }

    public Map<String, Object> petSizeCodeAdd(PetSizeDto petSizeDto) {
        Map<String, Object> res = new HashMap<>();
    
        Optional<PetSizeCodeMember> existingPetSize = petSizeRepository.findByCode(petSizeDto.getCode());
    
        if (existingPetSize.isEmpty()) {
            PetSizeCodeMember newPetSizeCodeMember = PetSizeCodeMember.builder()
                .code(petSizeDto.getCode())
                .codeExp(petSizeDto.getCodeExp())
                .codeGroup(petSizeDto.getCodeGroup())
                .petSize(petSizeDto.getPetSize())
                .build();
    
            petSizeRepository.save(newPetSizeCodeMember);
    
            res.put("message", "add success");
        } else {
            res.put("message", "failed");
        }
    
        return res;
    }

    public Map<String, Object> userStatusCodeAdd(UserStatusDto userStatusDto) {
        Map<String, Object> res = new HashMap<>();
    
        Optional<UserStatusCodeMember> existingUserStatus = userStatusRepository.findByCode(userStatusDto.getCode());
    
        if (existingUserStatus.isEmpty()) {
            UserStatusCodeMember newUserStatusCodeMember = UserStatusCodeMember.builder()
                .code(userStatusDto.getCode())
                .codeExp(userStatusDto.getCodeExp())
                .codeGroup(userStatusDto.getCodeGroup())
                .userStatus(userStatusDto.getUserStatus())
                .build();
    
                userStatusRepository.save(newUserStatusCodeMember);
    
            res.put("message", "add success");
        } else {
            res.put("message", "failed");
        }
    
        return res;
    }

    public Map<String, Object> deleteCodeGroup(Long codeGroup){
        CodeTypeMember codeTypeMember = codeTypeRepository.findByCodeGroup(codeGroup).get();
        codeTypeRepository.delete(codeTypeMember);

        List<PetSizeCodeMember> sizes = petSizeRepository.findAllByCodeGroup(codeGroup);
        List<PetKindCodeMember> kinds = petKindRepository.findAllByCodeGroup(codeGroup);
        List<UserStatusCodeMember> users = userStatusRepository.findAllByCodeGroup(codeGroup);

        for(PetSizeCodeMember size : sizes){
            petSizeRepository.delete(size);
        }

        for(PetKindCodeMember kind : kinds){
            petKindRepository.delete(kind);
        }

        for(UserStatusCodeMember user : users){
            userStatusRepository.delete(user);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("message", "deleted");

        return response;
    }

    public Map<String, Object> deletePetSizeCode(Integer petSizeCode){
        PetSizeCodeMember petSizeCodeMember = petSizeRepository.findByCode(petSizeCode).get();
        petSizeRepository.delete(petSizeCodeMember);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "deleted");

        return response;
    }

    public Map<String, Object> deletePetKindCode(Integer petKindCode){
        PetKindCodeMember petKindCodeMember = petKindRepository.findByCode(petKindCode).get();
        petKindRepository.delete(petKindCodeMember);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "deleted");

        return response;
    }

    public Map<String, Object> deleteUserStatusCode(Integer userStatusCode){
        UserStatusCodeMember userStatusCodeMember = userStatusRepository.findByCode(userStatusCode).get();
        userStatusRepository.delete(userStatusCodeMember);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "deleted");

        return response;
    }
    
}
