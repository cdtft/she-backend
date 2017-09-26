package com.cdut.dao.mysql.repository.admin;

import com.cdut.common.repository.CommonJpaRepository;
import com.cdut.dao.mysql.po.admin.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by king on 2017/9/11.
 */
@Repository
public interface UserRepository extends CommonJpaRepository<User, String>, UserDao, JpaSpecificationExecutor<User> {

    User findByUsername(String username);

    User findById(Long id);

    @Modifying
    @Query("update User u set u.password = :password where u.id = :id")
    void updatePasswordById(@Param("id") Long id, @Param("password") String password);
}
