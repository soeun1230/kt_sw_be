package kt.be.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kt.be.model.members.UserMember;
import kt.be.model.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // @Override
    // public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    //     return userRepository.findByEmail(email)
    //             .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    // }

    @Override
    public UserMember loadUserByUsername(String email) throws UsernameNotFoundException {
        UserMember userMember = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        return userMember;  // UserMember가 UserDetails를 구현한다고 가정
    }

}

