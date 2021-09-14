package com.digitalinnovationone.springwebmvcprojectintermadiate.controller;

import com.digitalinnovationone.springwebmvcprojectintermadiate.controller.request.SoldierEditRequest;
import com.digitalinnovationone.springwebmvcprojectintermadiate.controller.response.SoldierListResponse;
import com.digitalinnovationone.springwebmvcprojectintermadiate.controller.response.SoldierResponse;
import com.digitalinnovationone.springwebmvcprojectintermadiate.dto.Soldier;
import com.digitalinnovationone.springwebmvcprojectintermadiate.service.SoldierService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/soldier")
public class SoldierController {

    private final SoldierService soldierService;

    public SoldierController(SoldierService soldierService) {
        this.soldierService = soldierService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoldierResponse> findSoldier(@PathVariable() Long id) {
        SoldierResponse soldierResponse = soldierService.findSoldier(id);
        return ResponseEntity.status(HttpStatus.OK).body(soldierResponse);
    }

    @PostMapping
    public ResponseEntity createSoldier(@RequestBody Soldier soldier) {
        soldierService.createSoldier(soldier);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity editSoldier(@PathVariable Long id,
                                      @RequestBody SoldierEditRequest soldierEditRequest) {
        soldierService.editSoldier(id, soldierEditRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/front-castle/{id}")
    public ResponseEntity frontCastle(@PathVariable Long id) {
        //TO SOMETHING
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSoldier(@PathVariable Long id) {
        soldierService.deleteSoldier(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<CollectionModel<SoldierListResponse>> listSoldiers() {
        CollectionModel<SoldierListResponse> soldierListResponses = soldierService.listSoldiers();
        return  ResponseEntity.status(HttpStatus.OK).body(soldierListResponses);
    }
}
