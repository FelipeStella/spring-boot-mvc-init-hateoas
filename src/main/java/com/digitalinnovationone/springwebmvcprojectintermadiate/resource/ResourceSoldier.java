package com.digitalinnovationone.springwebmvcprojectintermadiate.resource;

import com.digitalinnovationone.springwebmvcprojectintermadiate.controller.SoldierController;
import com.digitalinnovationone.springwebmvcprojectintermadiate.controller.response.SoldierListResponse;
import com.digitalinnovationone.springwebmvcprojectintermadiate.controller.response.SoldierResponse;
import com.digitalinnovationone.springwebmvcprojectintermadiate.entity.SoldierEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ResourceSoldier {

    private ObjectMapper objectMapper;

    public ResourceSoldier(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public SoldierListResponse createLink (SoldierEntity soldierEntity) {
        SoldierListResponse soldierListResponse = objectMapper.convertValue(soldierEntity, SoldierListResponse.class);
        Link link = linkTo(methodOn(SoldierController.class).findSoldier(soldierEntity.getId())).withSelfRel();
        soldierListResponse.add(link);
        return soldierListResponse;
    }

    public SoldierResponse createLinkDetail (SoldierEntity soldierEntity) {
        SoldierResponse soldierResponse = objectMapper.convertValue(soldierEntity, SoldierResponse.class);
        if(soldierEntity.getStatus().equals("death")) {
            Link link = linkTo(methodOn(SoldierController.class).deleteSoldier(soldierEntity.getId()))
                    .withRel("remove")
                    .withTitle("Delete soldier")
                    .withType("delete");
            soldierResponse.add(link);
        }else if(soldierEntity.getStatus().equals("alive")) {
            Link link = linkTo(methodOn(SoldierController.class).frontCastle(soldierEntity.getId()))
                    .withRel("to battle")
                    .withTitle("Soldier go to the front of the castle")
                    .withType("put");
            soldierResponse.add(link);
        }

        return soldierResponse;
    }
}
