package com.example.companytracker.persistence.repository;

import com.example.companytracker.persistence.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentPostgresRepository extends JpaRepository<DepartmentEntity, String> {
}
