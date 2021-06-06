package com.business.rrhh.module.login.model.database;

import com.business.rrhh.module.company.model.database.CompanyEntity;
import com.business.rrhh.util.database.AuditEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
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

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "user_company",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "company_id")}
    )
    private Set<CompanyEntity> companies;

    @Builder
    public UserEntity(Integer id, String username, String password, String status, Set<CompanyEntity> companies) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
        this.companies = companies;
    }

    public UserEntity() {
        super();
    }

}
