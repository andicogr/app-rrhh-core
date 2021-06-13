package com.business.rrhh.module.login.model.database;

import com.business.rrhh.module.company.model.database.CompanyEntity;
import com.business.rrhh.util.model.database.AuditEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class UserEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(length = 20, nullable = false, unique = true)
    private String username;

    @Column(length = 300, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String status;

    @ManyToMany
    @JoinTable(
            name = "user_company",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "company_id")}
    )
    private Set<CompanyEntity> companies;

}
