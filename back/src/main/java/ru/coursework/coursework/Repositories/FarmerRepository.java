package ru.coursework.coursework.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.coursework.coursework.Entity.Farmer;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer,Integer> {

}
