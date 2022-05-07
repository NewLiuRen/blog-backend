package com.shadow.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

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
  private String tagId;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private String gmtCreate;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private String gmtModified;
}
