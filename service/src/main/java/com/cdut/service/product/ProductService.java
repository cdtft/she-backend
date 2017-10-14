package com.cdut.service.product;

import com.cdut.common.entity.JsonResult;
import com.cdut.dao.mysql.po.product.ProductPo;
import oracle.jrockit.jfr.ProducerDescriptor;

/**
 * Created by xieqiang_daye on 2017/10/13.
 */
public interface ProductService {
    /*
    * 查询所有的商品
    * */
    JsonResult findAllPro();

    /*
    * 根据Id查询商品
    * */
    JsonResult findById(Long id);
    /*
    * 根据商品名字查询商品
    * */
    JsonResult findByProcName(String name);
    /*
    * 添加商品/修改商品
    * */
    JsonResult save(ProductPo productPo);

    /*
    * 删除商品
    * */
    JsonResult delete(Long procId);
}

