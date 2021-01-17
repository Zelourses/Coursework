package ru.coursework.coursework.DTO.request;

import java.util.Objects;

public class newSoldierRequest {
    private Integer squad_id;
    private String name;
    private String weapon_type;
    private Integer kills;

    public Integer getSquad_id() {
        return squad_id;
    }

    public void setSquad_id(Integer squad_id) {
        this.squad_id = squad_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon_type() {
        return weapon_type;
    }

    public void setWeapon_type(String weapon_type) {
        this.weapon_type = weapon_type;
    }

    public Integer getKills() {
        return kills;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        newSoldierRequest that = (newSoldierRequest) o;
        return Objects.equals(squad_id, that.squad_id) && Objects.equals(name, that.name) && Objects.equals(weapon_type, that.weapon_type) && Objects.equals(kills, that.kills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(squad_id, name, weapon_type, kills);
    }

    @Override
    public String toString() {
        return "newSoldierRequest{" +
                "squad_id=" + squad_id +
                ", name='" + name + '\'' +
                ", weapon_name='" + weapon_type + '\'' +
                ", kills='" + kills + '\'' +
                '}';
    }
}
