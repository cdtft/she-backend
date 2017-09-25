package com.cdut.dao.mysql.repository.admin;

import com.cdut.common.repository.CommonJpaRepository;
import com.cdut.dao.mysql.po.admin.Permission;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by king on 2017/9/25.
 */
@Repository
public interface PermissionRepository extends CommonJpaRepository<Permission, Long>,PermissionDao, JpaSpecificationExecutor<Permission> {
}
