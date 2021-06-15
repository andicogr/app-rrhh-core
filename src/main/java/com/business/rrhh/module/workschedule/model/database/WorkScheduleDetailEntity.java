package com.business.rrhh.module.workschedule.model.database;

import com.business.rrhh.util.model.database.AuditEntity;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "work_schedule_detail")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class WorkScheduleDetailEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "work_schedule_id")
    private WorkScheduleEntity workSchedule;

    private DayOfWeek dayOfWeek;

    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime openingTime;

    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime departureTime;

    private LocalTime workTime;

}
