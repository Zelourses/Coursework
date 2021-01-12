package ru.coursework.coursework.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.coursework.coursework.Entity.Farmer;

public interface FarmerRepository extends JpaRepository<Farmer,Integer> {

}
