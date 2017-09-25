package com.cdut.dao.mysql.po.admin;

import com.cdut.common.entity.BaseEntity;
import com.cdut.common.entity.BasePo;
import com.cdut.common.entity.Identifiable;

import javax.persistence.*;
import java.util.List;


/**
 * Created by king on 2017/9/25.
 */
@Entity
@Table(name = "adm_permission")
public class Permission extends BasePo<Long> implements Identifiable<Long> {


    private static final long serialVersionUID = -8436471296764732212L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    /**
     * 权限名称
     */
    @Column(length = 40)
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 角色
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cdut_role_permission",
            joinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"permission_id", "role_id"})}
    )
    private List<Role> roles;

    @Override
    public Long getId() {
        return Id;
    }

    @Override
    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
