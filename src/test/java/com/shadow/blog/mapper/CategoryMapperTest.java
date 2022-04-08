package com.shadow.blog.mapper;

import com.shadow.blog.BlogApplication;
import com.shadow.blog.domain.CategoryDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author L.R
 * @date 2022-4-6 10:56
 */
@SpringBootTest(classes= BlogApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryMapperTest {
  @Autowired
  private CategoryMapper categoryMapper;

  @Test
  public void insertTest () {
    CategoryDO categoryDO = new CategoryDO();
    categoryMapper.insert(categoryDO);
  }
}
