package com.digitalinnovationone.springwebmvcprojectintermadiate.controller.request;

import com.digitalinnovationone.springwebmvcprojectintermadiate.controller.response.SoldierResponse;
import com.digitalinnovationone.springwebmvcprojectintermadiate.enums.Race;

public class SoldierEditRequest {

    private String name;
    private String weapon;
    private String race;

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

}
