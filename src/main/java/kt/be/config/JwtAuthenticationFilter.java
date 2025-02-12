package kt.be.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kt.be.components.JwtUtil;

@WebFilter(urlPatterns = "/api/**") // 원하는 API 경로에만 적용
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    //private final CustomUserDetailsService customUserDetailsService;

    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
        //this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Authorization 헤더에서 토큰 추출
        String token = getJwtFromRequest(request);

        if (token != null && jwtUtil.validateToken(token) != null) {
            String email = jwtUtil.validateToken(token);  // 토큰 유효성 검증 후 이메일 추출

            //UserMember userMember = 
            //UserMember userMember = customUserDetailsService.loadUserByUsername(email);

            // 인증 정보 설정
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    email, null, null); // 이메일을 인증된 사용자로 설정 (권한 부여 필요시 수정)

            SecurityContextHolder.getContext().setAuthentication(authentication); // 인증 정보 설정
        }

        filterChain.doFilter(request, response); // 필터 체인 계속 진행
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");

        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7); // "Bearer " 제외하고 토큰 추출
        }
        return null;
    }
}
