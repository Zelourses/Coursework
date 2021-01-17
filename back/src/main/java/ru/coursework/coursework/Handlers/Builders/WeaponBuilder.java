package ru.coursework.coursework.Handlers.Builders;

import ru.coursework.coursework.Entity.Weapon;

public class WeaponBuilder {
    private Weapon weapon;

    WeaponBuilder(){
        weapon = new Weapon();
    }

    public WeaponBuilder setType(String type){
        this.weapon.setWeapon_type(type);
        return this;
    }
}
