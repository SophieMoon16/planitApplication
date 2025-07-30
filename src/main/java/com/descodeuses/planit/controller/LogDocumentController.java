package com.descodeuses.planit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.descodeuses.planit.dto.AuthRequest;
import com.descodeuses.planit.dto.AuthResponse;
import com.descodeuses.planit.service.LogDocumentService;

@RestController
public class LogDocumentController {
@Autowired
private LogDocumentService logService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request){
        this.logService.addLog("login called");

    AuthResponse response = new AuthResponse();
    response.setToken("dummy-token"); // ici, un token fictif pour l'exemple

    return ResponseEntity.ok(response);  // <- on retourne bien un ResponseEntity
}
    }

