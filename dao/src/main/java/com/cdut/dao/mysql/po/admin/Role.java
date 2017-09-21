package com.cdut.dao.mysql.po.admin;

import com.cdut.common.entity.BaseEntity;

import javax.persistence.*;

/**
 * 角色表
 * Created by king on 2017/9/19.
 */
@Entity
@Table(name = "adm_role")
public class Role extends BaseEntity{

    private static final long serialVersionUID = -3185608378006931774L;

    /**
     * id主键，自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 角色名称
     */
    @Column(length = 40, nullable = false)
    private String name;

    /**
     * 角色描述信息
     */
    private String description;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
