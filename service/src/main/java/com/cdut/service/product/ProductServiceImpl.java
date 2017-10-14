package com.cdut.service.product;

import com.cdut.common.AbstractBaseService;
import com.cdut.common.entity.JsonResult;
import com.cdut.common.myenum.ResultStatus;
import com.cdut.dao.mysql.po.product.ProductPo;
import com.cdut.dao.mysql.repository.product.ProductDao;
import com.cdut.dao.mysql.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xieqiang_daye on 2017/10/13.
 */
@Service
public class ProductServiceImpl extends AbstractBaseService implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public JsonResult findAllPro() {
        List<ProductPo> list = new ArrayList<ProductPo>();
        list = productRepository.findAll();
        if(list!=null&&list.size()>0){
            return  new JsonResult(list,"查询所有商品成功", ResultStatus.SUCCESS);
        }
        return new JsonResult("未查询到所有商品",ResultStatus.NO_CONTENT);
    }

    /*
    * 查询产品
    * */
    public JsonResult findById(Long id) {
        ProductPo productPo = null;
        productPo = productRepository.findById(id);
        if(productPo!=null){
            return  new JsonResult(productPo,"查询到商品",ResultStatus.SUCCESS);
        }
        return new JsonResult("为查询到商品",ResultStatus.INVALID_REQUEST);
    }

    @Override
    public JsonResult findByProcName(String name) {
        return null;
    }

    @Override
    public JsonResult save(ProductPo productPo) {
        return null;
    }

    @Override
    public JsonResult delete(Long procId) {
        return null;
    }
}
