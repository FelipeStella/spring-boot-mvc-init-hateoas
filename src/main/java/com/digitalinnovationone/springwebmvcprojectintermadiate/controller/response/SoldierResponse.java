package com.digitalinnovationone.springwebmvcprojectintermadiate.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

public class SoldierResponse extends RepresentationModel {

    private Long id;
    private String cpf;
    private String name;
    private String weapon;
    private String race;
    private String status;

    @JsonProperty("id")
    public Long getResourceId() {
        return id;
    }

    @JsonProperty("id")
    public void setResourceId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
