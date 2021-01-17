package ru.coursework.coursework.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.coursework.coursework.Entity.Squad;

@Repository
public interface SquadRepository extends JpaRepository<Squad,Integer> {
}
