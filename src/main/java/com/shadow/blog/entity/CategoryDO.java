package com.shadow.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author L.R
 * @date 2022-3-31 10:36
 */
@Data
@NoArgsConstructor
@TableName("blog_category")
public class CategoryDO {
  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private String id;
  private Integer level;
  private String name;
  private String icon;
  private String color;
  private String parentId;
  private Integer orderNum;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private String gmtCreate;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private String gmtModified;
}
