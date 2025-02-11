package kt.be.controller;


import kt.be.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/api/auth/register")
    public ResponseEntity<String> register(@RequestBody Map<String, String> request) {
        String message = authService.register(
                request.get("email"), request.get("password"), request.get("name"), request.get("phone")
        );
        return ResponseEntity.ok(message);
    }

    @PostMapping("/api/auth/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> request) {
        String[] tokens = authService.login(request.get("email"), request.get("password"));
        return ResponseEntity.ok(Map.of("access_token", tokens[0], "refresh_token", tokens[1]));
    }

    @PostMapping("/api/auth/refresh")
    public ResponseEntity<Map<String, String>> refreshAccessToken(@RequestBody Map<String, String> request) {
        String refreshToken = request.get("refresh_token");
        String newAccessToken = authService.refreshAccessToken(refreshToken);
        return ResponseEntity.ok(Map.of("access_token", newAccessToken));
    }
}
