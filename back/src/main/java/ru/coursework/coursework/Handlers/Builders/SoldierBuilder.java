package ru.coursework.coursework.Handlers.Builders;

import ru.coursework.coursework.DTO.request.newSoldierRequest;
import ru.coursework.coursework.Entity.Soldier;
import ru.coursework.coursework.Entity.Squad;

//Builder with Director inside
public class SoldierBuilder {
    private Soldier soldier;

    public SoldierBuilder(){
        soldier = new Soldier();
    }

    public void reset(){
        soldier = new Soldier();
    }

    /**
     * @param request request from server
     * @param squad_id Squad object that used to "pin" soldier to squad
     * @return simple soldier without weapon. Because we have a little problem with database structure, we need to create
     * soldier without weapon and then-weapon, to attach it to a soldier :<
     */
    public Soldier buildSimpleSoldier(newSoldierRequest request, Squad squad_id){
        soldier.setCounter_Emu(request.getKills());
        soldier.setSoldier_name(request.getName());
        soldier.setSquad_id(squad_id);
        return soldier;
    }
}
