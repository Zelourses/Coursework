package ru.coursework.coursework.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "soldier")
public class Soldier {
    @Id
    @Column(name = "soldier_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int soldier_id;

    @Column(name = "counter_emu")
    private int counter_Emu;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "weapon_id")
    private Weapon weapon_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "squad_id")
    private Squad squad_id;

    @Column(name = "last_fight_id")
    private Integer last_fight_id;

    @Column(name = "status", columnDefinition = "boolean default true")
    private boolean status;

    private String soldier_name;

    public int getSoldier_id() {
        return soldier_id;
    }

    public void setSoldier_id(int soldier_id) {
        this.soldier_id = soldier_id;
    }

    public int getCounter_Emu() {
        return counter_Emu;
    }

    public void setCounter_Emu(int counter_Emu) {
        this.counter_Emu = counter_Emu;
    }

    public Weapon getWeapon_id() {
        return weapon_id;
    }

    public void setWeapon_id(Weapon weapon_id) {
        this.weapon_id = weapon_id;
    }

    public Squad getSquad_id() {
        return squad_id;
    }

    public void setSquad_id(Squad squad_id) {
        this.squad_id = squad_id;
    }

    public Integer getLast_fight_id() {
        return last_fight_id;
    }

    public void setLast_fight_id(Integer last_fight_id) {
        this.last_fight_id = last_fight_id;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getSoldier_name() {
        return soldier_name;
    }

    public void setSoldier_name(String soldier_name) {
        this.soldier_name = soldier_name;
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "id=" + soldier_id +
                ", counter_Emu=" + counter_Emu +
                ", weapon_id=" + weapon_id +
                ", squad_id=" + squad_id +
                ", last_fight_id=" + last_fight_id +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Soldier soldier = (Soldier) o;
        return soldier_id == soldier.soldier_id && counter_Emu == soldier.counter_Emu && status == soldier.status && Objects.equals(weapon_id, soldier.weapon_id) && Objects.equals(squad_id, soldier.squad_id) && Objects.equals(last_fight_id, soldier.last_fight_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(soldier_id, counter_Emu, weapon_id, squad_id, last_fight_id, status);
    }

}
