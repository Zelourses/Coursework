package ru.coursework.coursework.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.coursework.coursework.DTO.request.newSoldierRequest;
import ru.coursework.coursework.Entity.Soldier;
import ru.coursework.coursework.Entity.Squad;
import ru.coursework.coursework.Entity.Weapon;
import ru.coursework.coursework.Handlers.Builders.SoldierBuilder;
import ru.coursework.coursework.Repositories.SoldierRepository;
import ru.coursework.coursework.Repositories.SquadRepository;
import ru.coursework.coursework.Repositories.WeaponRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SoldiersService {


    final
    SoldierRepository soldierRepository;
    final
    SquadRepository squadRepository;
    final
    WeaponRepository weaponRepository;

    SoldiersService(SoldierRepository soldierRepository, SquadRepository squadRepository, WeaponRepository weaponRepository){
        this.soldierRepository = soldierRepository;
        this.squadRepository = squadRepository;
        this.weaponRepository = weaponRepository;
    }

    @Transactional
    public void newSoldier(newSoldierRequest soldierRequest){
        try{
            if(squadRepository.existsById(soldierRequest.getSquad_id())){
                Squad squad = squadRepository.getOne(soldierRequest.getSquad_id());

                SoldierBuilder builder = new SoldierBuilder();
                Soldier soldier_save = builder.buildSimpleSoldier(soldierRequest,squad);
                soldier_save =soldierRepository.save(soldier_save);

                if (!soldierRequest.getWeapon_type().trim().equals("")|| !soldierRequest.getWeapon_type().trim().equals(" ")) {
                    Weapon weapon = new Weapon();
                    weapon.setWeapon_type(soldierRequest.getWeapon_type());
                    weapon.setSoldier_last_id(soldier_save);
                    //weapon = weaponRepository.save(weapon);
                    weaponRepository.save(weapon);
                    soldier_save.setWeapon_id(weapon);

                }
                soldierRepository.save(soldier_save);

            }
        }catch (Exception e){

        }
    }
}
