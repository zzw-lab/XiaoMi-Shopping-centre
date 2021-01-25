package com.imooc.mall.service;

import com.imooc.mall.MallApplicationTests;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.ShippingForm;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
@Slf4j
public class IShippingServiceTest extends MallApplicationTests {

    @Autowired
    private IShippingService shippingService;

    private ShippingForm form;

    private Integer uid=1;

    private Integer shippingId;

    @Before
    public void before(){
        ShippingForm form = new ShippingForm();
        form.setReceiverName("赵志伟");
        form.setReceiverProvince("浙江");
        form.setReceiverCity("宁波");
        form.setReceiverDistrict("镇海区");
        form.setReceiverMobile("15906602473");
        form.setReceiverPhone("0123456");
        form.setReceiverAddress("浙江省宁波市镇海区");
        form.setReceiverZip("000000");
        this.form = form;
        add();
    }

    public void add() {
        ResponseVo<Map<String, Integer>> responseVo = shippingService.add(uid, form);
        log.info("result={}",responseVo);
        this.shippingId = responseVo.getData().get("shippingId");
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @After
    public void delete() {
        ResponseVo responseVo = shippingService.delete(uid, shippingId);
        log.info("result={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void update() {
        form.setReceiverName("赵志伟111");
        form.setReceiverProvince("浙江111");
        form.setReceiverCity("宁波111");
        form.setReceiverDistrict("镇海区111");
        form.setReceiverMobile("15906602473000");
        form.setReceiverPhone("0123456000");
        form.setReceiverAddress("浙江省宁波市镇海区1111");
        form.setReceiverZip("1111");
        ResponseVo responseVo = shippingService.update(uid, shippingId,form);
        log.info("result={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }

    @Test
    public void list() {
        ResponseVo responseVo = shippingService.list(uid, 1,10);
        log.info("result={}",responseVo);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }
}