package com.shadow.blog.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shadow.blog.BlogApplication;
import com.shadow.blog.entity.CategoryDO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author L.R
 * @date 2022-4-6 10:56
 */
@SpringBootTest(classes= BlogApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CategoryMapperTest {
  @Autowired
  private CategoryMapper categoryMapper;
  private List<CategoryDO> categoryDOList;

  @Before
  public void getCategoryList () {
    QueryWrapper<CategoryDO> wrapper = new QueryWrapper();
    this.categoryDOList = categoryMapper.selectList(wrapper);
  }

  // 先执行插入
  @Test
  public void test_01_insertTest () {
    CategoryDO categoryDO1 = new CategoryDO();
    CategoryDO categoryDO2 = new CategoryDO();
    int res1 = categoryMapper.insert(categoryDO1);
    int res2 = categoryMapper.insert(categoryDO2);
    Assert.assertTrue(res1 == 1 && res2 ==1);
  }


  // 获取第一层节点
  @Test
  public void test_02_listCategoryFirstLevelTest () {
    List<CategoryDO> categoryList = categoryMapper.listFirstLevelCategory();
    Assert.assertNotNull(categoryList);
    Assert.assertTrue(categoryList.size() == 2);
    Assert.assertTrue(categoryList.stream().allMatch(c -> c.getParentId().isEmpty()));
  }

  // 将第一个节点移至第二个节点下
  @Test
  public void test_03_moveCategoryTest () {
    CategoryDO categoryDO = categoryMapper.selectById("1522835700438036482");
//    CategoryDO parentCategoryDO = categoryMapper.selectById("1522835670897541122");
    CategoryDO parentCategoryDO = categoryMapper.selectById("1522835637427007490");
    categoryDO.setOrderNum(3);
    Integer integer = categoryMapper.moveCategory(categoryDO, parentCategoryDO);
    Assert.assertTrue(integer == 1);
  }

  // 获取其他层节点
  @Test
  public void test_04_listCategoryOtherLevelTest () {
    List<CategoryDO> categoryList = categoryMapper.listOtherLevelCategory(categoryDOList.get(0).getId());
    Assert.assertNotNull(categoryList);
//    Assert.assertTrue(categoryList.size() == 1);
    Assert.assertTrue(categoryList.stream().allMatch(c -> !c.getParentId().isEmpty()));
  }

  // 获取其他层节点
  @Test
  public void test_05_listCategoryParentTest () {
    List<CategoryDO> categoryList = categoryMapper.listParentCategory("1517420984282689537");
    System.out.println("categoryList: "+categoryList);
    System.out.println("size: "+categoryList.size());
    Assert.assertNotNull(categoryList);
  }

  @Test
  public void test_06_deleteTest () {
    int res1 = categoryMapper.deleteById(this.categoryDOList.get(0).getId());
    int res2 = categoryMapper.deleteById(this.categoryDOList.get(1).getId());

    Assert.assertTrue(res1 == 1 && res2 == 1);
  }
}
