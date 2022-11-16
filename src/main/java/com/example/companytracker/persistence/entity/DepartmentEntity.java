package com.example.companytracker.persistence.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "department")
@Table(name = "departments")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentEntity {
    @Id
    @Column(name = "department_id")
    private String departmentId;

    @Column(unique=true)
    private String name;
}
