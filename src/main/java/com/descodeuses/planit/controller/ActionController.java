package com.descodeuses.planit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import com.descodeuses.planit.dto.ActionDTO;
import com.descodeuses.planit.service.ActionService;

@RestController
@RequestMapping("/api/action")
@CrossOrigin(origins = "*") // Facultatif ou configure une origine spécifique
public class ActionController {

    private final ActionService actionService;

    @Autowired
    public ActionController(ActionService actionService) {
        this.actionService = actionService;
    }

    // ✅ Renvoie la liste de toutes les actions
    @GetMapping
    public ResponseEntity<List<ActionDTO>> getAllActions() {
        List<ActionDTO> actions = actionService.getAllActions();
        return new ResponseEntity<>(actions, HttpStatus.OK);
    }

    // ✅ Renvoie une action par ID
    @GetMapping("/{id}")
    public ResponseEntity<ActionDTO> getActionById(@PathVariable Long id) {
        ActionDTO action = actionService.getActionById(id);
        return new ResponseEntity<>(action, HttpStatus.OK);
    }

    // ✅ Crée une nouvelle action
    @PostMapping
    public ResponseEntity<ActionDTO> createAction(@RequestBody ActionDTO actionDTO) {
        ActionDTO createdAction = actionService.createAction(actionDTO);
        return new ResponseEntity<>(createdAction, HttpStatus.CREATED);
    }

    // ✅ Met à jour une action existante
    @PutMapping("/{id}")
    public ResponseEntity<ActionDTO> updateAction(@PathVariable Long id, @RequestBody ActionDTO actionDTO) {
        ActionDTO updatedAction = actionService.updateAction(id, actionDTO);
        return new ResponseEntity<>(updatedAction, HttpStatus.OK);
    }

    // ✅ Supprime une action par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAction(@PathVariable Long id) {
        actionService.deleteAction(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}