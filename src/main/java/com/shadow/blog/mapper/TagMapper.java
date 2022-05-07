package com.shadow.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shadow.blog.entity.TagDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author L.R
 * @date 2022-4-28 11:32
 */
@Mapper
public interface TagMapper extends BaseMapper<TagDO> {
  /**
   * 查询所有标签
   * @return 标签集合
   */
  List<TagDO> listTag();

  /**
   * 根据id字符串查询指定的标签集合
   * @param ids id字符串，逗号分隔
   * @return 标签集合
   */
  List<TagDO> listTagByIds(String ids);
}
