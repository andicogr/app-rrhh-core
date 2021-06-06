package com.business.rrhh.util.database;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@MappedSuperclass
public class AuditEntity {

    private String createdBy;

    private String modifiedBy;

    private LocalDateTime created;

    private LocalDateTime modified;

    @PrePersist
    protected void prePersist() {

        if (Objects.isNull(created)) this.created = LocalDateTime.now();

    }

    @PreUpdate
    protected void preUpdate(){

        this.modified = LocalDateTime.now();

    }

}
