package com.business.rrhh.module.employee.model.database;

import com.business.rrhh.module.company.model.database.CompanyEntity;
import com.business.rrhh.module.sunat.annex.two.model.database.Table3Entity;
import com.business.rrhh.util.DocType;
import com.business.rrhh.util.model.database.BaseCompanyEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class EmployeeEntity extends BaseCompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(length = 100)
    private String secondName;

    @Column(nullable = false, length = 100)
    private String paternalName;

    @Column(length = 100)
    private String maternalName;

    @Column(length = 400)
    private String fullName;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DocType documentType;

    @Column(nullable = false, length = 15)
    private String documentNumber;

    @Column(length = 100)
    private String email;

    @Column(length = 15)
    private String workPhone;

    @Column(length = 15)
    private String mobilePhone;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate bornDate;

    @Builder
    public EmployeeEntity(CompanyEntity company, Integer id, String firstName, String secondName, String paternalName, String maternalName, String fullName, String state, DocType documentType, String documentNumber, String email, String workPhone, String mobilePhone, LocalDate bornDate) {
        super(company);
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.paternalName = paternalName;
        this.maternalName = maternalName;
        this.fullName = fullName;
        this.state = state;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.email = email;
        this.workPhone = workPhone;
        this.mobilePhone = mobilePhone;
        this.bornDate = bornDate;
    }

    public EmployeeEntity() {
        super(null);
    }
}
