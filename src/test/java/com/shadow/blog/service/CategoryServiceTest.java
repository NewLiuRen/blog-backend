package com.shadow.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shadow.blog.BlogApplication;
import com.shadow.blog.entity.CategoryDO;
import com.shadow.blog.mapper.CategoryMapper;
import org.assertj.core.util.Strings;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author L.R
 * @date 2022-4-19 11:55
 */
@SpringBootTest(classes = BlogApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryServiceTest {
  @Autowired
  private CategoryService categoryService;
  @Autowired
  private CategoryMapper categoryMapper;
  private List<CategoryDO> listCategoryDO;

  @Before
  public void getCategoryList () {
    QueryWrapper<CategoryDO> wrapper = new QueryWrapper();
    this.listCategoryDO = categoryMapper.selectList(wrapper);
  }

  @Test
  public void listFirstLevelCategoryTest() {
    List<CategoryDO> categoryList = categoryService.listFirstLevelCategory();

    Assert.assertTrue(categoryList.stream().allMatch(c ->
            Strings.isNullOrEmpty(c.getParentId()))
    );
  }

  @Test
  public void  listOtherLevelCategoryTest() {
    List<CategoryDO> categoryList = categoryService.listOtherLevelCategory("1522835637427007490");
    System.out.println("count: " + categoryList.size());
    System.out.println(categoryList);
    Assert.assertTrue(categoryList.stream().allMatch(c ->
            !Strings.isNullOrEmpty(c.getParentId())
    ));
  }

  @Test
  public void moveCategoryTest () {
    CategoryDO categoryDO = categoryMapper.selectById("1522835700438036482");
    CategoryDO parentCategoryDO = categoryMapper.selectById("1522835670897541122");
//    CategoryDO parentCategoryDO = categoryMapper.selectById("1522835637427007490");
    categoryDO.setOrderNum(3);
    Boolean flag = categoryService.moveCategory(categoryDO, parentCategoryDO);
    Assert.assertTrue(flag);
  }
}
