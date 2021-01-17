package ru.coursework.coursework.Entity;

import javax.persistence.*;

@Entity
@Table(name = "complaints")
public class Complaint {
    @Id
    @Column(name = "complaint_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farmer_id")
    private Farmer farmer_id;

    private Integer square_number;

    @Column(length = 256,columnDefinition = "varchar(256)")
    private String short_description;

    protected Complaint(){

    }

    public Complaint(Farmer farmer_id, Integer square_number, String short_description){
        this.farmer_id=farmer_id;
        this.square_number=square_number;
        this.short_description = short_description;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Farmer getFarmer_id() {
        return farmer_id;
    }

    public void setFarmer_id(Farmer farmer_id) {
        this.farmer_id = farmer_id;
    }

    public Integer getSquare_number() {
        return square_number;
    }

    public void setSquare_number(Integer square_number) {
        this.square_number = square_number;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }
}
