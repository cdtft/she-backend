package com.cdut.dao.mysql.repository.admin;

import com.cdut.common.repository.CommonJpaRepository;
import com.cdut.dao.mysql.po.admin.Role;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by king on 2017/9/25.
 */
@Repository
public interface RoleRepository extends CommonJpaRepository<Role, Long>, RoleDao, JpaSpecificationExecutor<Role> {
}
