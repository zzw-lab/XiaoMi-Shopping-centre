package com.imooc.mall.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//开启swagger
@EnableSwagger2
public class SwaggerConfig {


//    @Bean
//    public Docket createRestApi(){
//        //版本类型是swagger2
//        return new Docket(DocumentationType.SWAGGER_2)
//                //通过调用自定义方法apiInfo，获得文档的主要信息
//                .apiInfo(apiInfo())
//                .select()//通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现
//                //.apis(RequestHandlerSelectors.basePackage("com.imooc.mall.controller"))//扫描该包下面的API注解
//                .paths(PathSelectors.any())
//                .build();
//    }
//    //API相关信其他息
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("赵志伟的API文档") //接口管理文档首页显示
//                .description("电商网站API")
//                .version("1.0")
//                .build();//API的描述
//                // .termsOfServiceUrl("www.baidu.com")//网站url等
//
//    }
}

