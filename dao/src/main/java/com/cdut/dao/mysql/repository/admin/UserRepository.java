package com.cdut.dao.mysql.repository.admin;

import com.cdut.common.repository.CommonJpaRepository;
import com.cdut.dao.mysql.po.admin.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by king on 2017/9/11.
 */
@Repository
public interface UserRepository extends CommonJpaRepository<User, String>, UserDao, JpaSpecificationExecutor<User> {

    User findByUsername(String username);

    User findById(String id);

    @Query("update user set password = ?2 where id = ?1")
    void updatePasswordById(String id, String password);
}
