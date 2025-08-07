package com.descodeuses.planit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.descodeuses.planit.entity.ActionEntity;
import java.util.List;

public interface ActionRepository extends JpaRepository<ActionEntity, Long> {
    /*List<ActionEntity> findbyUtilisateurId(Long utilisateurId);*/

}