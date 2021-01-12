package ru.coursework.coursework.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.coursework.coursework.Entity.Complaint;

public interface ComplaintsRepository extends JpaRepository<Complaint,Integer> {
}
