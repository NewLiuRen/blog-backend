package com.shadow.blog.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author L.R
 * @date 2022-3-31 10:36
 */
@Data
@NoArgsConstructor
public class CategoryDO {
  private Integer id;
  private Integer level;
  private String name;
  private String icon;
  private String color;
  private String parentId;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date gmtCreate;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date gmtModified;
}
