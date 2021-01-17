package ru.coursework.coursework.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.coursework.coursework.Entity.Complaint;

@Repository
public interface ComplaintsRepository extends JpaRepository<Complaint,Integer> {
}
