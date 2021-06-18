package com.business.rrhh.module.employee.model.database;

import com.business.rrhh.module.employee.SystemHealthType;
import com.business.rrhh.util.model.database.AuditEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_system_health")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class SystemHealthEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeEntity employee;

    private SystemHealthType type;

    @Column(nullable = false)
    private LocalDate startDate;

}
