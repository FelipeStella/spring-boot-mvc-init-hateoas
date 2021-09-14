package com.digitalinnovationone.springwebmvcprojectintermadiate.controller.request;

import com.digitalinnovationone.springwebmvcprojectintermadiate.enums.Race;

public class SoldierRequest {

    private String cpf;
    private String name;
    private String weapon;
    private Race race;
    private String status;

    public static SoldierRequest create() {
        SoldierRequest soldierMock = new SoldierRequest();
        soldierMock.setCpf("839487880-49");
        soldierMock.setName("Thais Duarte");
        soldierMock.setRace(Race.HUMANO);
        soldierMock.setStatus("alive");
        soldierMock.setWeapon("shield");
        return soldierMock;
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
