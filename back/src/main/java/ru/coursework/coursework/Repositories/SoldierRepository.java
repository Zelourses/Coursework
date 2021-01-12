package ru.coursework.coursework.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.coursework.coursework.Entity.Soldier;

@Repository
public interface SoldierRepository extends JpaRepository<Soldier,Integer> {

}
