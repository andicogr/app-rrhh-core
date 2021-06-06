package com.business.rrhh.module.login.model.database;

import com.business.rrhh.module.company.model.database.CompanyEntity;
import com.business.rrhh.util.database.BaseCompanyEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class UserEntity extends BaseCompanyEntity {

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

    @Builder
    public UserEntity(CompanyEntity company, Integer id, String username, String password, String status) {
        super(company);
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public UserEntity() {
        super(null);
    }
}
