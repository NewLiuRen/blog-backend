package com.shadow.blog.service;

import com.shadow.blog.entity.CategoryDO;

import java.util.List;

/**
 * @author L.R
 * @date 2022-4-18 9:55
 */
public interface CategoryService {
  /**
   * 查询第一级category
   * @return category集合
   */
  List<CategoryDO> listFirstLevelCategory();

  /**
   * 根据第一级id递归查询所有下级category
   * @param id 第一级category的id
   * @return category集合
   */
  List<CategoryDO> listOtherLevelCategory(String id);

  /**
   * 插入category
   * @param categoryDO category对象
   * @return 是否成功
   */
  Boolean insertCategory(CategoryDO categoryDO);

  /**
   * 修改category信息
   * @param categoryDO category对象
   * @return 是否成功
   */
  Boolean updateCategory(CategoryDO categoryDO);

  /**
   * 删除category
   * @param id 待删除的category的id
   * @return 是否成功
   */
  Boolean deleteCategory(String id);

  /**
   * 移动category节点位置至指定category下
   * @param categoryDO 待移动的category节点对象
   * @param parentCategoryDO 目标父节点
   * @return 是否成功
   */
  Boolean moveCategory(CategoryDO categoryDO, CategoryDO parentCategoryDO);
}
