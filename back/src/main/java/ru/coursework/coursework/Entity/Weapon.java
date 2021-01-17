package ru.coursework.coursework.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "weapon")
@SecondaryTable(name = "war_conflict")
@SecondaryTable(name = "soldier")
public class Weapon {

    @Id
    @Column(name = "weapon_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "boolean default true")
    private boolean status;

    @Column(length = 40,columnDefinition = "varchar(40)")
    private String weapon_type;

    @OneToOne
    @JoinColumn(name = "soldier_last_id")
    private Soldier soldier_last_id;

    @OneToOne
    @JoinColumn(table = "war_conflict",name = "conflict_id")
    private WarConflict last_fight_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getWeapon_type() {
        return weapon_type;
    }

    public void setWeapon_type(String weapon_type) {
        this.weapon_type = weapon_type;
    }

    public Soldier getSoldier_last_id() {
        return soldier_last_id;
    }

    public void setSoldier_last_id(Soldier soldier_last_id) {
        this.soldier_last_id = soldier_last_id;
    }

    public WarConflict getLast_fight_id() {
        return last_fight_id;
    }

    public void setLast_fight_id(WarConflict last_fight_id) {
        this.last_fight_id = last_fight_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return status == weapon.status && Objects.equals(id, weapon.id) && Objects.equals(weapon_type, weapon.weapon_type) && Objects.equals(soldier_last_id, weapon.soldier_last_id) && Objects.equals(last_fight_id, weapon.last_fight_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, weapon_type, soldier_last_id, last_fight_id);
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "id=" + id +
                ", status=" + status +
                ", weapon_type='" + weapon_type + '\'' +
                ", soldier_last_id=" + soldier_last_id +
                ", last_fight_id=" + last_fight_id +
                '}';
    }
}
