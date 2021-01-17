package ru.coursework.coursework.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "squad")
public class Squad {

    @Id
    @Column(name = "squad_id")
    private int id;

    /*
     *  (01.2021)
     * Changed from Soldier to int, because i don't know
     * how to map this relation right(If here would be Soldier instead of int
     * repository.getOne() always will get all soldiers instead of one that is captain
     * We have this "problematic" relation:
     * Many soldiers have field Squad_id that shows that they are from the same squad
     * while Squad has captain_id field that shows captain of this squad
     * if somebody knows how to map this right, write me please
     * because i haven't found the way that i could solve this,
     * only by changing it to int and find captain by soldierRepository
     */
    private int captain_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCaptain_id() {
        return captain_id;
    }

    public void setCaptain_id(int captain_id) {
        this.captain_id = captain_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Squad squad = (Squad) o;
        return id == squad.id && Objects.equals(captain_id, squad.captain_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, captain_id);
    }

    @Override
    public String toString() {
        return "Squad{" +
                "id=" + id +
                ", captain_id=" + captain_id +
                '}';
    }
}
