package com.cdut.dao.mysql.po.product;

import com.cdut.common.entity.BaseEntity;
import com.cdut.dao.mysql.po.admin.User;

import javax.persistence.*;
import java.util.List;

/**
 * 订单
 * Created by king on 2017/9/20.
 */
@Entity
@Table(name = "pro_order")
public class Order extends BaseEntity{

    private static final long serialVersionUID = -6029290510109630974L;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private User user;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductPo> productPoList;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ProductPo> getProductPoList() {
        return productPoList;
    }

    public void setProductPoList(List<ProductPo> productPoList) {
        this.productPoList = productPoList;
    }
}
