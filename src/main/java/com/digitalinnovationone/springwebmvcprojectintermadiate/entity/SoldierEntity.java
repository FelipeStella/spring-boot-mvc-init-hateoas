package com.digitalinnovationone.springwebmvcprojectintermadiate.entity;

import com.digitalinnovationone.springwebmvcprojectintermadiate.controller.response.SoldierResponse;
import com.digitalinnovationone.springwebmvcprojectintermadiate.enums.Race;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SoldierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cpf;
    private String name;
    private String weapon;
    private Race race;
    private String status;

    public static SoldierEntity create() {
        SoldierEntity soldierMock = new SoldierEntity();
        soldierMock.setId(1L);
        soldierMock.setCpf("839494880-49");
        soldierMock.setName("Felipe Stella");
        soldierMock.setRace(Race.HUMANO);
        soldierMock.setStatus("alive");
        soldierMock.setWeapon("sword");
        return soldierMock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
