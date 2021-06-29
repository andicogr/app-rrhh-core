package com.business.rrhh.module.employee.model.business;

import com.business.rrhh.module.company.model.business.Company;
import com.business.rrhh.util.DocType;
import com.business.rrhh.util.model.business.State;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

import static org.apache.commons.lang3.StringUtils.isEmpty;

@Data
@Builder
public class Employee {

    private Integer id;
    private String firstName;
    private String secondName;
    private String paternalName;
    private String maternalName;
    private String fullName;
    private State state;
    private DocType documentType;
    private String documentNumber;
    private String email;
    private String workPhone;
    private String mobilePhone;
    private LocalDate bornDate;
    private Company company;

    public void buildFullName() {

        this.fullName = this.firstName
                .concat(isEmpty(this.secondName) ? StringUtils.EMPTY : " ".concat(this.secondName))
                .concat(" ")
                .concat(this.paternalName)
                .concat(isEmpty(this.maternalName) ? StringUtils.EMPTY : " ".concat(this.maternalName));

    }

}
