package kt.be.service;

import kt.be.components.JwtUtil;
import kt.be.model.members.ShopCartMember;
import kt.be.model.members.UserMember;
import kt.be.model.repository.ShopCartRepository;
import kt.be.model.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final ShopCartRepository shopCartRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository, ShopCartRepository shopCartRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.shopCartRepository = shopCartRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.jwtUtil = jwtUtil;
    }

    // 회원가입
    public String register(String email, String password, String name, String phone) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("이미 가입된 이메일입니다.");
        }

        UserMember user = new UserMember();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setUserName(name);
        user.setUserPhone(phone);
        user.setUserCode(0);   //0 : 일반 사용자,  1: 펫시터 등록까지 한 사용자
        userRepository.save(user);

        ShopCartMember shopCartMember = new ShopCartMember();
        shopCartMember.setUser(user);
        shopCartRepository.save(shopCartMember);

        return "회원가입 성공";
    }

    // 로그인
    public String[] login(String email, String password) {
        Optional<UserMember> userOpt = userRepository.findByEmail(email);
        if (userOpt.isEmpty() || !passwordEncoder.matches(password, userOpt.get().getPassword())) {
            throw new RuntimeException("이메일 또는 비밀번호가 일치하지 않습니다.");
        }

        // 토큰 생성
        String accessToken = jwtUtil.generateAccessToken(email);
        String refreshToken = jwtUtil.generateRefreshToken(email);

        return new String[] { accessToken, refreshToken };
    }

    // Refresh Token을 이용해 새로운 Access Token 발급
    public String refreshAccessToken(String refreshToken) {
        String email = jwtUtil.validateToken(refreshToken);
        if (email == null) {
            throw new RuntimeException("유효하지 않은 refresh token입니다.");
        }
        return jwtUtil.generateRefreshToken(email); // 새로운 access token 발급
    }
}

