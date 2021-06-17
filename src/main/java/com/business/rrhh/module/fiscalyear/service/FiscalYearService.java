package com.business.rrhh.module.fiscalyear.service;

import com.business.rrhh.module.fiscalyear.dao.FiscalYearDao;
import com.business.rrhh.module.fiscalyear.error.FiscalYearException;
import com.business.rrhh.module.fiscalyear.model.business.FiscalYear;
import com.business.rrhh.module.fiscalyear.state.FiscalYearStates;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.business.rrhh.util.UpdateObjects.requireNonNullElse;

@Service
@AllArgsConstructor
public class FiscalYearService {

    private final FiscalYearDao dao;

    public Page<FiscalYear> getByPage(FiscalYear fiscalYear, PageRequest pageRequest) {

        return dao.getByPage(fiscalYear, pageRequest);

    }

    public List<FiscalYear> getAll(FiscalYear fiscalYear) {

        return dao.getAll(fiscalYear);

    }

    public FiscalYear getById(Integer id) {

        return dao.getById(id);

    }

    public FiscalYear save(FiscalYear fiscalYear) {

        this.validate(fiscalYear);

        fiscalYear.setState(FiscalYearStates.DRAFT.buildState());

        return dao.save(fiscalYear);

    }

    public void updateById(FiscalYear fiscalYear) {

        this.validate(fiscalYear);

        FiscalYear foundedFiscalYear = dao.getById(fiscalYear.getId());

        foundedFiscalYear.setYear(requireNonNullElse(fiscalYear.getYear(), foundedFiscalYear.getYear()));

        dao.save(foundedFiscalYear);

    }

    private void validate(FiscalYear fiscalYear) {

        dao.findByName(fiscalYear)
                .ifPresent(foundedFiscalYear -> {

                    if (Objects.isNull(fiscalYear.getId())) {

                        throw FiscalYearException.YEAR_ALREADY_EXISTS.build();

                    } else if (Objects.nonNull(fiscalYear.getId())
                            && foundedFiscalYear.getId().intValue() != fiscalYear.getId().intValue()) {

                        throw FiscalYearException.YEAR_ALREADY_EXISTS.build();

                    }

                });

    }

    public void deleteById(Integer id) {

        dao.deleteById(id);

    }

    public void activate(Integer id) {

        FiscalYear fiscalYear = dao.getById(id);

        fiscalYear.setState(FiscalYearStates.OPEN.buildState());

        dao.save(fiscalYear);

    }

    public void close(Integer id) {

        FiscalYear fiscalYear = dao.getById(id);

        fiscalYear.setState(FiscalYearStates.CLOSE.buildState());

        dao.save(fiscalYear);

    }

}
