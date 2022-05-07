package com.shadow.blog.service.impl;

import com.shadow.blog.entity.CategoryDO;
import com.shadow.blog.mapper.CategoryMapper;
import com.shadow.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author L.R
 * @date 2022-4-18 16:37
 */
@Service
public class CategoryServiceImpl implements CategoryService {
  @Autowired
  private CategoryMapper categoryMapper;

  @Override
  public List<CategoryDO> listFirstLevelCategory() {
    return categoryMapper.listFirstLevelCategory();
  }

  @Override
  public List<CategoryDO> listOtherLevelCategory(String pid) {
    return categoryMapper.listOtherLevelCategory(pid);
  }

  @Override
  public Boolean insertCategory(CategoryDO categoryDO) {
    int res = categoryMapper.insert(categoryDO);
    return res == 1;
  }

  @Override
  public Boolean updateCategory(CategoryDO categoryDO) {
    int res = categoryMapper.updateBaseById(categoryDO);
    return  res == 1;
  }

  @Override
  public Boolean deleteCategory(String id) {
    int res = categoryMapper.deleteById(id);
    return res == 1;
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public Boolean moveCategory(CategoryDO categoryDO, CategoryDO parentCategoryDO) {
    Integer index = categoryDO.getOrderNum();
    List<CategoryDO> categoryDOList = categoryMapper.listCategoryByParentId(parentCategoryDO.getId());
    try {
      categoryDOList.stream()
              .filter(category -> category.getOrderNum() >= index)
              .forEach(category -> {
                category.setOrderNum(category.getOrderNum() + 1);
                categoryMapper.updateById(category);
              });
      categoryMapper.moveCategory(categoryDO, parentCategoryDO);
    } catch (Exception e) {
      e.printStackTrace();
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }
}
