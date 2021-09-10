package com.digitalinnovationone.springwebmvcprojectintermadiate.dto;

import com.digitalinnovationone.springwebmvcprojectintermadiate.enums.Race;

public class Soldier {

    private String cpf;
    private String name;
    private String weapon;
    private Race race;
    private String status;

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
