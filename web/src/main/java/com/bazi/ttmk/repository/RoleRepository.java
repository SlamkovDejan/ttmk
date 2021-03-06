package com.bazi.ttmk.repository;

import com.bazi.ttmk.model.Role;
import com.bazi.ttmk.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName roleName);

}