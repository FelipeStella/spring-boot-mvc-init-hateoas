package com.digitalinnovationone.springwebmvcprojectintermadiate.repository;

import com.digitalinnovationone.springwebmvcprojectintermadiate.entity.SoldierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldierRepository extends JpaRepository<SoldierEntity, Long> {
}
