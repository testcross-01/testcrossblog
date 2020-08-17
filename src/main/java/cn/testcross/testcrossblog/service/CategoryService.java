package cn.testcross.testcrossblog.service;

import cn.testcross.testcrossblog.bean.Category;

import java.util.List;

public interface CategoryService {

    /**
     * 基础增删改查
     */
    Category queryCategoryById(Integer id);
    void addCategory(Category category);
    void updateCategoryById(Integer id,Category category);
    void deleteCategoryById(Integer id);

    /**
     * 查询所有分类
     * @return
     */
    List<Category> queryAllCategory();

    /**
     * 查询所有子分类
     */
    List<Category> queryChildCategoryById(Integer id);


}
