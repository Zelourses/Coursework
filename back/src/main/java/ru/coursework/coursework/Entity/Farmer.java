package ru.coursework.coursework.Entity;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DynamicUpdate
@Table(name = "farmer")
public class Farmer {

    @Id
    @Column(name = "farmer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 80)
    private String name;

    private Integer counter_denunciation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCounter_denunciation() {
        return counter_denunciation;
    }

    public void setCounter_denunciation(Integer counter_denunciation) {
        this.counter_denunciation = counter_denunciation;
    }

    //does we really need function that adds only 1 to this?
    public void addCounter_denunciation(Integer counter_denunciation){
        this.counter_denunciation+=counter_denunciation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Farmer farmer = (Farmer) o;
        return Objects.equals(id, farmer.id) && Objects.equals(name, farmer.name) && Objects.equals(counter_denunciation, farmer.counter_denunciation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, counter_denunciation);
    }
}
