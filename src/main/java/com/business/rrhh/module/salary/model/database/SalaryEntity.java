package com.business.rrhh.module.salary.model.database;

import com.business.rrhh.module.company.model.database.CompanyEntity;
import com.business.rrhh.module.employee.model.database.EmployeeEntity;
import com.business.rrhh.module.sunat.annex.two.model.database.Table3Entity;
import com.business.rrhh.util.model.database.BaseCompanyEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "salary")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class SalaryEntity extends BaseCompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeEntity employee;

    @Column(nullable = false, precision = 10, scale = 4)
    private BigDecimal amount;

    @Column(nullable = false, precision = 10, scale = 4)
    private BigDecimal netAmount;

    private Boolean familyAllowance;

    @JoinColumn(nullable = false)
    private LocalDate startDate;

    private LocalDate endDate;

    @JoinColumn(nullable = false)
    private String state;

    @Builder
    public SalaryEntity(CompanyEntity company, Integer id, EmployeeEntity employee, BigDecimal amount, BigDecimal netAmount, Boolean familyAllowance, LocalDate startDate, LocalDate endDate, String state) {
        super(company);
        this.id = id;
        this.employee = employee;
        this.amount = amount;
        this.netAmount = netAmount;
        this.familyAllowance = familyAllowance;
        this.startDate = startDate;
        this.endDate = endDate;
        this.state = state;
    }

    public SalaryEntity() {
        super(null);
    }
}
