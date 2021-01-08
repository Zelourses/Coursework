package ru.coursework.coursework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.coursework.coursework.Entity.Soldier;

@Repository
public interface SoldierRepository extends JpaRepository<Soldier,Integer> {

}
