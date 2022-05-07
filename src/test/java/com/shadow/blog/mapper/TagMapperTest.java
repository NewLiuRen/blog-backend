package com.shadow.blog.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shadow.blog.BlogApplication;
import com.shadow.blog.entity.TagDO;
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
 * @date 2022-4-28 15:28
 */
@SpringBootTest(classes= BlogApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TagMapperTest {
  @Autowired
  private TagMapper tagMapper;
  private List<TagDO> tagDOList;

  @Before
  public void getTagList () {
    QueryWrapper<TagDO> wrappers = new QueryWrapper();
    tagDOList = tagMapper.selectList(wrappers);
  }

  @Test
  public void test_01_insertTest () {
    TagDO tagDO = new TagDO();
    int res = tagMapper.insert(tagDO);
    Assert.assertTrue(res == 1);
  }

  @Test
  public void test_02_updateTest () {
    if (this.tagDOList.isEmpty()) return;
    TagDO tagDO = tagDOList.get(0);
    tagDO.setName("testName");
    int res = tagMapper.updateById(tagDO);
    TagDO tagDONew = tagMapper.selectById(tagDO.getId());
    Assert.assertTrue("testName".equals(tagDONew.getName()));
  }

  @Test
  public void test_03_deleteTest () {
    if (this.tagDOList.isEmpty()) return;
    TagDO tagDO = tagDOList.get(0);
    int res = tagMapper.deleteById(tagDO.getId());
    Assert.assertTrue((res == 1));
  }

  @Test
  public void test_04_getTagList () {
    List<TagDO> tagDOS = tagMapper.listTag();
    System.out.println(tagDOS);
    Assert.assertTrue(tagDOS.size() > 0);
  }

  @Test
  public void test_05_listTagByIds () {
    String ids = "1519922583588585473,1519922618476851201,1519922655961296898";
    List<TagDO> tagDOS = tagMapper.listTagByIds(ids);
    System.out.println(tagDOS);
    String[] idArr = ids.split(",");
    System.out.println(tagDOS.get(0).getGmtCreate());
    Assert.assertTrue(tagDOS.size() == idArr.length);
    Assert.assertTrue(tagDOS.stream().allMatch(tagDO -> ids.contains(tagDO.getId())));
  }
}
