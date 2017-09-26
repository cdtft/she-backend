package com.cdut.dao.mysql.po.admin;

import com.cdut.common.entity.BasePo;
import com.cdut.common.entity.Identifiable;
import com.cdut.common.myenum.CdutCommonStatus;

import javax.persistence.*;
import java.util.List;

/**
 * 角色表
 * Created by king on 2017/9/19.
 */
@Entity
@Table(name = "adm_role")
public class Role extends BasePo<Long> implements Identifiable<Long> {

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

    /**
     * 角色权限
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cdut_role_permission",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"role_id", "permission_id"})}
    )
    private List<Permission> permissions;

    @Column
    @Enumerated(EnumType.STRING)
    private CdutCommonStatus status = CdutCommonStatus.ENABLE;

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

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public CdutCommonStatus getStatus() {
        return status;
    }

    public void setStatus(CdutCommonStatus status) {
        this.status = status;
    }
}
