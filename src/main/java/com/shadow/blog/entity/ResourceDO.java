package com.shadow.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author L.R
 * @date 2022-3-31 10:36
 */
@Data
@TableName("blog_resource")
public class ResourceDO {
  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private String id;
  private Integer level;
  private String resourceName;
  private String description;
  private String parentId;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private String gmtCreate;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private String gmtModified;
}
