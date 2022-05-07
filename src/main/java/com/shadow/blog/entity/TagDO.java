package com.shadow.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author L.R
 * @date 2022-4-18 10:48
 */
@Data
@TableName("blog_tag")
public class TagDO {
  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private String id;
  private String name;
  private String icon;
  private String color;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private String gmtCreate;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private String gmtModified;
}
