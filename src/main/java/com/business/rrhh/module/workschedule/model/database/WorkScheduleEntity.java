package com.business.rrhh.module.workschedule.model.database;

import com.business.rrhh.module.company.model.database.CompanyEntity;
import com.business.rrhh.util.model.database.BaseCompanyEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "work_schedule")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class WorkScheduleEntity extends BaseCompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    private Integer openingTolerance;

    private Integer departureTolerance;

    private Boolean active;

    @OneToMany(mappedBy = "workSchedule", fetch = FetchType.LAZY)
    @OrderBy(value = "dayOfWeek asc")
    private List<WorkScheduleDetailEntity> details;

    @Builder
    public WorkScheduleEntity(CompanyEntity company, Integer id, String name, Integer openingTolerance, Integer departureTolerance, Boolean active, List<WorkScheduleDetailEntity> details) {
        super(company);
        this.id = id;
        this.name = name;
        this.openingTolerance = openingTolerance;
        this.departureTolerance = departureTolerance;
        this.active = active;
        this.details = details;
    }

    public WorkScheduleEntity() {
        super(null);
    }
}
