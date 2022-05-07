package com.shadow.blog.service.impl;

import com.shadow.blog.entity.TagDO;
import com.shadow.blog.mapper.TagMapper;
import com.shadow.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author L.R
 * @date 2022-4-29 8:37
 */
@Service
public class TagServiceImpl implements TagService {
  @Autowired
  private TagMapper tagMapper;

  @Override
  public List<TagDO> listTag() {
    return tagMapper.listTag();
  }

  @Override
  public List<TagDO> listTagByIds(String ids) {
    return tagMapper.listTagByIds(ids);
  }

  @Override
  public Boolean insertTag(TagDO tagDO) {
    return tagMapper.insert(tagDO) == 1;
  }

  @Override
  public Boolean updateTag(TagDO tagDO) {
    return tagMapper.updateById(tagDO) == 1;
  }

  @Override
  public Boolean deletaTag(String id) {
    return tagMapper.deleteById(id) == 1;
  }
}
