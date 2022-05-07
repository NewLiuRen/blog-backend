package com.shadow.blog.service;

import com.shadow.blog.entity.TagDO;

import java.util.List;

/**
 * @author L.R
 * @date 2022-4-18 10:58
 */
public interface TagService {
  /**
   * 查询所有tag
   * @return tag集合
   */
  List<TagDO> listTag();

  /**
   * 根据id字符串查询指定的tag集合
   * @param ids id字符串，逗号分隔
   * @return tag集合
   */
  List<TagDO> listTagByIds(String ids);

  /**
   * 添加tag
   * @param tagDO tag对象
   * @return 是否成功
   */
  Boolean insertTag(TagDO tagDO);

  /**
   * 修改tag
   * @param tagDO tag对象
   * @return 是否成功
   */
  Boolean updateTag(TagDO tagDO);

  /**
   * 删除tag
   * @param id 待删除的tag的id
   * @return 是否成功
   */
  Boolean deletaTag(String id);
}
