package com.business.rrhh.module.afp.model.database;

import com.business.rrhh.util.model.database.AuditEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "afp")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class AfpEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String name;

    private Boolean active;

}
