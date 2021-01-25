package com.imooc.mall.controller;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.consts.MallConst;
import com.imooc.mall.form.OrderCreateForm;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IOrderService;
import com.imooc.mall.vo.OrderVo;
import com.imooc.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
public class OrderController {

    @Autowired
    private IOrderService iOrderService;

    @PostMapping("/orders")
    public ResponseVo<OrderVo> create(@Valid @RequestBody OrderCreateForm form,
                                      @ApiIgnore HttpSession session){
        User user = (User)session.getAttribute(MallConst.CURRENT_USER);
        return iOrderService.create(user.getId(), form.getShippingId());
    }

    @GetMapping("/orders")
    public ResponseVo<PageInfo> list(@RequestParam Integer pageNum,
                                     @RequestParam Integer pageSize,
                                     @ApiIgnore HttpSession session){
        User user = (User)session.getAttribute(MallConst.CURRENT_USER);
        return iOrderService.list(user.getId(), pageNum,pageSize);
    }

    @GetMapping("/orders/{orderNo}")
    public ResponseVo<OrderVo> detail(@PathVariable Long orderNo,
                                      @ApiIgnore HttpSession session){
        User user = (User)session.getAttribute(MallConst.CURRENT_USER);
        return iOrderService.detail(user.getId(), orderNo);
    }

    @PutMapping("/orders/{orderNo}")
    public ResponseVo cancel(@PathVariable Long orderNo,
                             @ApiIgnore HttpSession session){
        User user = (User)session.getAttribute(MallConst.CURRENT_USER);
        return iOrderService.cancel(user.getId(), orderNo);
    }
}
