package com.business.rrhh.module.afp.model.database;

import com.business.rrhh.module.afp.AfpType;
import com.business.rrhh.module.fiscalyear.model.database.FiscalYearEntity;
import com.business.rrhh.util.model.database.AuditEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Month;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "afp_commissions")
@SequenceGenerator(name = "seq_afp_commissions", sequenceName = "seq_afp_commissions", initialValue = 1, allocationSize = 1)
public class AfpCommissionEntity extends AuditEntity {

    @Id
    @GeneratedValue(generator = "seq_afp_commissions", strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fiscal_year_id", nullable = false)
    private FiscalYearEntity fiscalYear;

    @Column(nullable = false)
    private Month month;

    @ManyToOne
    @JoinColumn(name = "afp_id", nullable = false)
    private AfpEntity afp;

    @Column(precision = 10, scale = 4)
    private BigDecimal commission;

    @Column(precision = 10, scale = 4)
    private BigDecimal contribution;

    @Column(precision = 10, scale = 4)
    private BigDecimal insurance;

    @Column(precision = 10, scale = 4)
    private BigDecimal maximumRemuneration;

    @Column(nullable = false)
    private AfpType type;

}
