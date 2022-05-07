package com.shadow.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shadow.blog.entity.CategoryDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author L.R
 * @date 2022-3-31 17:18
 */
@Mapper
public interface CategoryMapper extends BaseMapper<CategoryDO> {
  /**
   * 查询第一层category
   * @return CategoryList
   */
  List<CategoryDO> listFirstLevelCategory();

  /**
   * 根据id递归查询该层下的所有category
   * @param pid 父级id
   * @return CategoryList
   */
  List<CategoryDO> listOtherLevelCategory(String pid);


  /**
   * 根据id查询该层下的所有category
   * @param id 待查询的节点id
   * @return category集合
   */
  List<CategoryDO> listCategoryByParentId(String id);

  /**
   * 更新目录的基本信息
   * @param categoryDO 待更新的目录对象
   * @return 是否成功
   */
  Integer updateBaseById(@Param("categoryDO") CategoryDO categoryDO);

  /**
   * 根据id查询所有祖先节点
   * @param id 待查询的节点
   * @return CategoryList
   */
  List<CategoryDO> listParentCategory(String id);

  /**
   * 移动category节点
   * @param categoryDO 待移动的category对象
   * @param parentCategoryDO 移动到的父级category对象
   * @return 执行结果
   */
  Integer moveCategory(@Param("categoryDO") CategoryDO categoryDO, @Param("parentCategoryDO") CategoryDO parentCategoryDO);
}
