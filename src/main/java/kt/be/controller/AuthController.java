package kt.be.controller;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kt.be.service.AuthService;
import kt.be.service.BasicUserService;

@RestController
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final AuthService authService;
    private final BasicUserService basicUserService;

    public AuthController(AuthService authService, BasicUserService basicUserService) {
        this.authService = authService;
        this.basicUserService = basicUserService;
    }

    @PostMapping("/api/auth/register")
    public ResponseEntity<String> register(@RequestBody Map<String, String> request) {
        String message = authService.register(
                request.get("email"), request.get("password"), request.get("name"), request.get("phone")
        );
        return ResponseEntity.ok(message);
    }

    @PostMapping("/api/auth/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> request) {
        String[] tokens = authService.login(request.get("email"), request.get("password"));
        Long userId = Long.parseLong(tokens[2]);

        Map<String, String> userInfo = basicUserService.getUserInfo(userId);

        return ResponseEntity.ok(Map.of("access_token", tokens[0], "refresh_token", tokens[1], "userId", userId, "name", userInfo.get("name"), "email",userInfo.get("email")));
    }

    @PostMapping("/api/auth/refresh")
    public ResponseEntity<Map<String, String>> refreshAccessToken(@RequestBody Map<String, String> request) {
        String refreshToken = request.get("refresh_token");
        String newAccessToken = authService.refreshAccessToken(refreshToken);
        return ResponseEntity.ok(Map.of("access_token", newAccessToken));
    }
}
