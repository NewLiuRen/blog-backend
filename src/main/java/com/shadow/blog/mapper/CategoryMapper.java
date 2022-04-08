package com.shadow.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shadow.blog.domain.CategoryDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author L.R
 * @date 2022-3-31 17:18
 */
@Mapper
public interface CategoryMapper extends BaseMapper<CategoryDO> {
}
