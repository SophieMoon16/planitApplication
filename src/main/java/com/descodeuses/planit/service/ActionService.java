package com.descodeuses.planit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.descodeuses.planit.dto.ActionDTO;
import com.descodeuses.planit.entity.ActionEntity;
import com.descodeuses.planit.repository.ActionRepository;
import com.descodeuses.planit.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class ActionService {

    private final ActionRepository actionRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public ActionService(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    public List<ActionDTO> getAllActions() {
        List<ActionEntity> actions = actionRepository.findAll(Sort.by(Sort.Direction.DESC, "dueDate"));
        List<ActionDTO> actionDTOs = new ArrayList<>();
        for (ActionEntity action : actions) {
            actionDTOs.add(convertToDTO(action));
        }
        return actionDTOs;
    }

    public ActionDTO getActionById(Long id) {
        ActionEntity action = actionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Action not found with id: " + id));
        return convertToDTO(action);
    }

    public ActionDTO createAction(ActionDTO actionDTO) {
        ActionEntity action = convertToEntity(actionDTO);
        ActionEntity savedAction = actionRepository.save(action);
        return convertToDTO(savedAction);
    }

    public ActionDTO updateAction(Long id, ActionDTO actionDTO) {
        ActionEntity existingAction = actionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Action not found with id: " + id));

        existingAction.setTitle(actionDTO.getTitle());
        existingAction.setCompleted(actionDTO.isCompleted());
        existingAction.setPriorite(actionDTO.getPriorite());
        existingAction.setDueDate(actionDTO.getDueDate());

        ActionEntity updatedAction = actionRepository.save(existingAction);
        return convertToDTO(updatedAction);
    }

    public void deleteAction(Long id) {
        if (!actionRepository.existsById(id)) {
            throw new EntityNotFoundException("Action not found with id: " + id);
        }
        actionRepository.deleteById(id);
    }

    // Convert Entity to DTO
    private ActionDTO convertToDTO(ActionEntity action) {
        return new ActionDTO(
                action.getId(),
                action.getTitle(),
                action.getCompleted(),
                action.getPriorite(),
                action.getDueDate()
        );
    }

    // Convert DTO to Entity
    private ActionEntity convertToEntity(ActionDTO actionDTO) {
        ActionEntity action = new ActionEntity();
        if (actionDTO.getId() != null) {
            action.setId(actionDTO.getId());
        }
        action.setTitle(actionDTO.getTitle());
        action.setCompleted(actionDTO.isCompleted());
        action.setPriorite(actionDTO.getPriorite());
        action.setDueDate(actionDTO.getDueDate());
        return action;
    }
}

