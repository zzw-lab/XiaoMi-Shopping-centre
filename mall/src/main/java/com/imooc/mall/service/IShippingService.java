package com.imooc.mall.service;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.form.ShippingForm;
import com.imooc.mall.vo.ResponseVo;

import java.util.Map;

public interface IShippingService {

    ResponseVo<Map<String,Integer>> add(Integer uid, ShippingForm form);

    ResponseVo delete(Integer uid,Integer shippdingId);

    ResponseVo update(Integer uid,Integer shippdingId, ShippingForm form);

    ResponseVo<PageInfo> list(Integer uid,Integer pageNum,Integer pageSize);
}
