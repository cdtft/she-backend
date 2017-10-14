package com.cdut.dao.mysql.po.product;

import com.cdut.common.entity.BaseEntity;
import com.cdut.common.entity.Identifiable;

import javax.persistence.*;
import java.util.List;

/**
 * Created by xieqiang_daye on 2017/10/14.
 */

/*
* 分类目录
* */
@Entity
@Table(name = "pro_category")
public class Category extends BaseEntity implements Identifiable<Long>{
    @Column(length = 20)
    private  String cname;

    /*
    * 关联的商品
    * */
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<ProductPo>productPoList;

    public List<ProductPo> getProductPoList() {
        return productPoList;
    }
    public void setProductPoList(List<ProductPo> productPoList) {
        this.productPoList = productPoList;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }


}
