package ru.coursework.coursework.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "soldier")
public class Soldier {
    @Id
    @Column(name = "soldier_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "counter_emu")
    private int counter_Emu;

    @Column(name = "weapon_id")
    private Integer weapon_id;

    @Column(name = "squad_id")
    private Integer squad_id;

    @Column(name = "last_fight_id")
    private Integer last_fight_id;

    @Column(name = "status")
    private boolean status;

    public Soldier(int counter_Emu,
                   Integer weapon_id,
                   Integer squad_id,
                   Integer last_fight_id,
                   boolean status){
        this.counter_Emu = counter_Emu;
        this.weapon_id = weapon_id;
        this.squad_id = squad_id;
        this.last_fight_id = last_fight_id;
        this.status = status;
    }
    protected Soldier(){

    }

    @Override
    public String toString() {
        return "Soldier{" +
                "id=" + id +
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
        return id == soldier.id && counter_Emu == soldier.counter_Emu && status == soldier.status && Objects.equals(weapon_id, soldier.weapon_id) && Objects.equals(squad_id, soldier.squad_id) && Objects.equals(last_fight_id, soldier.last_fight_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, counter_Emu, weapon_id, squad_id, last_fight_id, status);
    }

    public static Soldier newSimpleSoldier(){
        return new Soldier(0,null,null,null,true);
    }

}
