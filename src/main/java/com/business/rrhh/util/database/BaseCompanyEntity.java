package com.business.rrhh.util.database;

import com.business.rrhh.module.company.model.database.CompanyEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BaseCompanyEntity extends AuditEntity {

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;

}
