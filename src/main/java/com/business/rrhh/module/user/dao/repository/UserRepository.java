package com.business.rrhh.module.user.dao.repository;

import com.business.rrhh.module.user.model.database.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>, JpaSpecificationExecutor<UserEntity> {

    Optional<UserEntity> findByUsernameAndPassword(String username, String password);

    boolean existsByUsername(String username);

    Optional<UserEntity> findByUsername(String username);

    boolean existsByIdNotAndUsername(Integer id, String username);

}
