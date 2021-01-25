package com.imooc.mall.dao;

import com.imooc.mall.pojo.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> selectAll();
}