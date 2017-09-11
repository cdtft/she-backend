package com.cdut.dao.mysql.po.demo;

import com.cdut.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * Created by king on 2017/9/11.
 */
@Entity
@Table(name = "pro_product")
public class ProductPo extends BaseEntity {

    private static final long serialVersionUID = -3004008471179571299L;

    @Column(length = 40)
    private String name;

    @Column(length = 40)
    private String type;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
