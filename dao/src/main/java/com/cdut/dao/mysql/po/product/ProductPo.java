package com.cdut.dao.mysql.po.product;

import com.cdut.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * Created by king on 2017/9/11.
 */
@Entity
@Table(name = "pro_product")
public class ProductPo extends BaseEntity {

    private static final long serialVersionUID = -3004008471179571299L;

    /**
     * 名称
     */
    @Column(length = 40)
    private String name;

    /**
     * 商品类型
     */
    @Column(length = 40)
    private String type;

    /**
     * 上传图片的url
     */
    private String url;

    @OneToOne
    private Order order;


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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
