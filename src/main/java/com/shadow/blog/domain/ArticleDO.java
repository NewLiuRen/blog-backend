package com.shadow.blog.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author L.R
 * @date 2022-4-1 8:49
 */
@Data
@TableName("blog_article")
public class ArticleDO {
  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private String id;
  private String title;
  private String description;
  private Integer clickCount;
  private Integer disagreeCount;
  private Boolean delete;
  private String contentId;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date gmtCreate;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date gmtModified;
}
