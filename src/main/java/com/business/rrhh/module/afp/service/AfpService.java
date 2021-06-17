package com.business.rrhh.module.afp.service;

import com.business.rrhh.module.afp.dao.AfpDao;
import com.business.rrhh.module.afp.error.AfpException;
import com.business.rrhh.module.afp.model.business.Afp;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.business.rrhh.util.UpdateObjects.requireNonNullElse;

@Service
@AllArgsConstructor
public class AfpService {

    private final AfpDao dao;

    public Page<Afp> getByPage(Afp afp, PageRequest pageRequest) {

        return dao.getByPage(afp, pageRequest);

    }

    public List<Afp> getAll(Afp afp) {

        return dao.getAll(afp);

    }

    public Afp getById(Integer id) {

        return dao.getById(id);

    }

    public Afp save(Afp afp) {

        this.validate(afp);

        return dao.save(afp);

    }

    public void updateById(Afp afp) {

        this.validate(afp);

        Afp foundedAfp = dao.getById(afp.getId());

        foundedAfp.setName(requireNonNullElse(afp.getName(), foundedAfp.getName()));
        foundedAfp.setActive(requireNonNullElse(afp.getActive(), foundedAfp.getActive()));

        dao.save(foundedAfp);

    }

    private void validate(Afp afp) {

        dao.findByName(afp)
                .ifPresent(foundedAfp -> {

                    if (Objects.isNull(afp.getId())) {

                        throw AfpException.NAME_ALREADY_EXISTS.build();

                    } else if (Objects.nonNull(afp.getId())
                            && foundedAfp.getId().intValue() != afp.getId().intValue()) {

                        throw AfpException.NAME_ALREADY_EXISTS.build();

                    }

                });

    }

    public void deleteById(Integer id) {

        dao.deleteById(id);

    }

}
