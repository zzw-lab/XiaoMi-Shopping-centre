package com.imooc.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserRegisterForm {
//    @NotBlank  用于String判断 空格
//    @NotNull  判断是不是null
//    @NotEmpty 用于集合检查是不是空
    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String email;
}
