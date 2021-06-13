package com.business.rrhh.module.sunat.annex.two.model.database;

import com.business.rrhh.module.company.model.database.CompanyEntity;
import com.business.rrhh.util.model.database.BaseCompanyEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "sunat_table_3")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Table3Entity extends BaseCompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(length = 10, nullable = false)
    private String code;

    @Column(length = 10, nullable = false)
    private String sunatCode;

    @Column(length = 100, nullable = false)
    private String description;

    private Boolean active;

    public Table3Entity(CompanyEntity company, Integer id, String code, String sunatCode, String description, Boolean active) {
        super(company);
        this.id = id;
        this.code = code;
        this.sunatCode = sunatCode;
        this.description = description;
        this.active = active;
    }

    public Table3Entity() {
        super(null);
    }
}
