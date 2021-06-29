package com.business.rrhh.module.employee.model.database;

import com.business.rrhh.module.afp.AfpType;
import com.business.rrhh.module.afp.model.database.AfpEntity;
import com.business.rrhh.module.employee.SystemPensionType;
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
@Table(name = "employee_system_pension")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class SystemPensionEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeEntity employee;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SystemPensionType type;

    @Column(nullable = false)
    private LocalDate startDate;

    @ManyToOne
    @JoinColumn(name = "afp_id")
    private AfpEntity afp;

    private AfpType afpType;

    private String cusppCode;

}
