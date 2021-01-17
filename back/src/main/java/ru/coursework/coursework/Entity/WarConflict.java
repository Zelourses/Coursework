package ru.coursework.coursework.Entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "war_conflict")

public class WarConflict {

    @Id
    @Column(name = "conflict_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer square_number;

    @OneToOne
    private Squad squad_id;

    private Integer emu_loss;

    private Integer soldiers_loss;

    private Integer mechanism_loss;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSquare_number() {
        return square_number;
    }

    public void setSquare_number(Integer square_number) {
        this.square_number = square_number;
    }

    public Squad getSquad_id() {
        return squad_id;
    }

    public void setSquad_id(Squad squad_id) {
        this.squad_id = squad_id;
    }

    public Integer getEmu_loss() {
        return emu_loss;
    }

    public void setEmu_loss(Integer emu_loss) {
        this.emu_loss = emu_loss;
    }

    public Integer getSoldiers_loss() {
        return soldiers_loss;
    }

    public void setSoldiers_loss(Integer soldiers_loss) {
        this.soldiers_loss = soldiers_loss;
    }

    public Integer getMechanism_loss() {
        return mechanism_loss;
    }

    public void setMechanism_loss(Integer mechanism_loss) {
        this.mechanism_loss = mechanism_loss;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WarConflict that = (WarConflict) o;
        return Objects.equals(id, that.id) && Objects.equals(square_number, that.square_number) && Objects.equals(squad_id, that.squad_id) && Objects.equals(emu_loss, that.emu_loss) && Objects.equals(soldiers_loss, that.soldiers_loss) && Objects.equals(mechanism_loss, that.mechanism_loss);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, square_number, squad_id, emu_loss, soldiers_loss, mechanism_loss);
    }

    @Override
    public String toString() {
        return "WarConflict{" +
                "id=" + id +
                ", square_number=" + square_number +
                ", squad_id=" + squad_id +
                ", emu_loss=" + emu_loss +
                ", soldiers_loss=" + soldiers_loss +
                ", mechanism_loss=" + mechanism_loss +
                '}';
    }
}
