package com.shadow.blog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

import java.util.Date;

/**
 * @author L.R
 * @date 2022-3-31 10:36
 */
@Data
public class ArticleDTO {
  private Integer id;
  private String title;
  private String description;
  private Integer clickCount;
  private Integer disagreeCount;
  private Boolean delete;
  private Integer contentId;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date gmtCreate;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date gmtModified;
}
