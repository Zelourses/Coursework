package ru.coursework.coursework.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.coursework.coursework.Entity.Weapon;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon,Integer> {
}
