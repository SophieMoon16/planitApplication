package com.descodeuses.planit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.descodeuses.planit.entity.ActionEntity;

public interface ActionRepository extends JpaRepository<ActionEntity, Long> {
    List<Action> findbyUtilisateurId(Long utilisateurId);

}