package com.business.rrhh.module.afp.service;

import com.business.rrhh.module.afp.dao.AfpCommissionDao;
import com.business.rrhh.module.afp.error.AfpCommissionException;
import com.business.rrhh.module.afp.model.business.Afp;
import com.business.rrhh.module.afp.model.business.AfpCommission;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.business.rrhh.util.UpdateObjects.requireNonNullElse;

@Service
@AllArgsConstructor
public class AfpCommissionService {

    private final AfpCommissionDao dao;

    public Page<AfpCommission> getByPage(Afp afp, PageRequest pageRequest) {

        return dao.getPageByParent(afp, pageRequest);

    }

    public AfpCommission getById(Integer afpId, Integer id) {

        return dao.getById(afpId, id);

    }

    public void save(AfpCommission afpCommission) {

        this.validate(afpCommission);

        dao.save(afpCommission);

    }

    public void update(AfpCommission afpCommission) {

        AfpCommission foundedAfpCommission = dao.getById(afpCommission.getAfp().getId(), afpCommission.getId());

        foundedAfpCommission.setFiscalYear(requireNonNullElse(afpCommission.getFiscalYear(), foundedAfpCommission.getFiscalYear()));
        foundedAfpCommission.setMonth(requireNonNullElse(afpCommission.getMonth(), foundedAfpCommission.getMonth()));
        foundedAfpCommission.setCommission(requireNonNullElse(afpCommission.getCommission(), foundedAfpCommission.getCommission()));
        foundedAfpCommission.setContribution(requireNonNullElse(afpCommission.getContribution(), foundedAfpCommission.getContribution()));
        foundedAfpCommission.setInsurance(requireNonNullElse(afpCommission.getInsurance(), foundedAfpCommission.getInsurance()));
        foundedAfpCommission.setMaximumRemuneration(requireNonNullElse(afpCommission.getMaximumRemuneration(), foundedAfpCommission.getMaximumRemuneration()));
        foundedAfpCommission.setType(requireNonNullElse(afpCommission.getType(), foundedAfpCommission.getType()));

        this.validate(foundedAfpCommission);

        dao.save(foundedAfpCommission);

    }

    private void validate(AfpCommission afpCommission) {

        dao.findToValidate(afpCommission)
                .ifPresent(foundedAfpCommission -> {

                    if (Objects.isNull(afpCommission.getId())) {

                        throw AfpCommissionException.COMMISSION_ALREADY_EXISTS.build();

                    } else if (Objects.nonNull(afpCommission.getId())
                            && foundedAfpCommission.getId().intValue() != afpCommission.getId().intValue()) {

                        throw AfpCommissionException.COMMISSION_ALREADY_EXISTS.build();

                    }

                });

    }

    public void deleteById(Integer afpId, Integer id) {

            dao.deleteById(afpId, id);

    }

}
