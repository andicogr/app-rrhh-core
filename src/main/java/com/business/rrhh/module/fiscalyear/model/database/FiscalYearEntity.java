package com.business.rrhh.module.fiscalyear.model.database;

import com.business.rrhh.util.model.database.AuditEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fiscal_year")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class FiscalYearEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Integer year;

    private String state;

}
