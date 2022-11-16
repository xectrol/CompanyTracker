package com.example.companytracker.persistence.repository;

import com.example.companytracker.persistence.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePostgresRepository extends JpaRepository<EmployeeEntity, String> {
}
