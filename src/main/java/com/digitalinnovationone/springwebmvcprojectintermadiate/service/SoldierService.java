package com.digitalinnovationone.springwebmvcprojectintermadiate.service;

import com.digitalinnovationone.springwebmvcprojectintermadiate.controller.request.SoldierEditRequest;
import com.digitalinnovationone.springwebmvcprojectintermadiate.controller.response.SoldierListResponse;
import com.digitalinnovationone.springwebmvcprojectintermadiate.controller.response.SoldierResponse;
import com.digitalinnovationone.springwebmvcprojectintermadiate.dto.Soldier;
import com.digitalinnovationone.springwebmvcprojectintermadiate.entity.SoldierEntity;
import com.digitalinnovationone.springwebmvcprojectintermadiate.repository.SoldierRepository;
import com.digitalinnovationone.springwebmvcprojectintermadiate.resource.ResourceSoldier;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SoldierService {

    private SoldierRepository soldierRepository;
    private ObjectMapper objectMapper;
    private ResourceSoldier resourceSoldier;


    public SoldierService(SoldierRepository soldierRepository, ObjectMapper objectMapper, ResourceSoldier resourceSoldier) {
        this.soldierRepository = soldierRepository;
        this.objectMapper = objectMapper;
        this.resourceSoldier = resourceSoldier;
    }

    public SoldierResponse findSoldier(Long id) {
        SoldierEntity soldierEntity = soldierRepository.findById(id).orElseThrow();
        SoldierResponse soldierResponse = resourceSoldier.createLinkDetail(soldierEntity);
        return soldierResponse;
    }

    public void createSoldier(Soldier soldier) {
        SoldierEntity soldierEntity = objectMapper.convertValue(soldier, SoldierEntity.class);
        soldierRepository.save(soldierEntity);
    }

    public void editSoldier(Long id, SoldierEditRequest soldierEditRequest) {
        SoldierEntity soldierEntity = objectMapper.convertValue(soldierEditRequest, SoldierEntity.class);
        soldierEntity.setId(id);
        soldierRepository.save(soldierEntity);
    }

    public void deleteSoldier(Long id) {
        SoldierEntity soldierEntity = soldierRepository.findById(id).orElseThrow();
        soldierRepository.delete(soldierEntity);
    }

    public CollectionModel<SoldierListResponse> listSoldiers() {
        List<SoldierEntity> all = soldierRepository.findAll();
        List<SoldierListResponse> soldierStream = all.stream()
                .map(it -> resourceSoldier.createLink(it))
                .collect(Collectors.toList());
        return new CollectionModel<>(soldierStream);
    }
}
