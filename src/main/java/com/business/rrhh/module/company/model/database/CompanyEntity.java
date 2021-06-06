package com.business.rrhh.module.company.model.database;

import com.business.rrhh.util.database.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
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

    private String status;

}
