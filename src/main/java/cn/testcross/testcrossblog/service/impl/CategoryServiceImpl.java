package cn.testcross.testcrossblog.service.impl;

import cn.testcross.testcrossblog.bean.ArticleCategoryRef;
import cn.testcross.testcrossblog.bean.ArticleCategoryRefExample;
import cn.testcross.testcrossblog.bean.Category;
import cn.testcross.testcrossblog.bean.CategoryExample;
import cn.testcross.testcrossblog.mapper.ArticleCategoryRefMapper;
import cn.testcross.testcrossblog.mapper.CategoryMapper;
import cn.testcross.testcrossblog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    ArticleCategoryRefMapper articleCategoryRefMapper;

    @Override
    public Category queryCategoryById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addCategory(Category category) {
        categoryMapper.insert(category);
    }

    @Override
    public void updateCategoryById(Integer id, Category category) {
        if(id==null||category.getCategoryId()==null)
            return;
        else if(!id.equals(category.getCategoryId())){
            category.setCategoryId(id);
        }
        categoryMapper.updateByPrimaryKey(category);
    }


    @Override
    @Transactional
    public void deleteCategoryById(Integer id) {
        categoryMapper.deleteByPrimaryKey(id);
        ArticleCategoryRefExample articleCategoryRefExample=new ArticleCategoryRefExample();
        articleCategoryRefExample.createCriteria().andArticleIdEqualTo(id);
        articleCategoryRefMapper.deleteByExample(articleCategoryRefExample);

    }

    @Override
    public List<Category> queryAllCategory() {
        return categoryMapper.selectByExample(null);
    }

    @Override
    public List<Category> queryChildCategoryById(Integer id) {
        CategoryExample categoryExample=new CategoryExample();
        categoryExample.createCriteria().andCategoryPidEqualTo(id);
        List<Category> categories=categoryMapper.selectByExample(categoryExample);
        return categories;
    }
}
