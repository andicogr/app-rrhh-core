package com.business.rrhh.module.company.model.database;

import com.business.rrhh.module.user.model.database.UserEntity;
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
@Table(name = "company")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class CompanyEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(length = 200, nullable = false, unique = true)
    private String brandName;

    @Column(length = 11, nullable = false, unique = true)
    private String ruc;

    @Column(length = 200)
    private String address;

    @Column(length = 20)
    private String phone;

    @Column(length = 64)
    private String email;

    private String state;

    @ManyToMany(mappedBy = "companies")
    private Set<UserEntity> users;

}
