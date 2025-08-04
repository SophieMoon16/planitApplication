package com.descodeuses.planit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.descodeuses.planit.dto.AuthRequest;
import com.descodeuses.planit.dto.AuthResponse;
import com.descodeuses.planit.security.JwtUtil;
import com.descodeuses.planit.service.LogDocumentService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private LogDocumentService logService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        // Authentifie l'utilisateur
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        // Génère un token JWT
        String token = jwtUtil.generateToken(request.getUsername());

        // Ajoute un log dans MongoDB
        logService.addLog("login exécuté pour l'utilisateur : " + request.getUsername());

        // Retourne le token dans la réponse
        return ResponseEntity.ok(new AuthResponse(token));
    }

}