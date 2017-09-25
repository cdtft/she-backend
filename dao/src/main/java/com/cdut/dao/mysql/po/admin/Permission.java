package com.cdut.dao.mysql.po.admin;

import com.cdut.common.entity.BasePo;
import com.cdut.common.entity.Identifiable;
import com.cdut.common.myenum.CdutCommonStatus;
import org.hibernate.validator.constraints.NotBlank;

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

    //TODO 确定正则匹配
    /**
     * 权限字符
     */
    @Column
    @NotBlank
    private String symbol;

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

    @Column
    @Enumerated(EnumType.STRING)
    private CdutCommonStatus status = CdutCommonStatus.ENABLE;

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

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public CdutCommonStatus getStatus() {
        return status;
    }

    public void setStatus(CdutCommonStatus status) {
        this.status = status;
    }
}
