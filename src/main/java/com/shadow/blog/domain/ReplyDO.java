package com.shadow.blog.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author L.R
 * @date 2022-3-31 10:36
 */
@Data
@TableName("blog_reply")
public class ReplyDO {
  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private String id;
  private String content;
  private String replyId;
  private String userId;
  private String articleId;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date gmtCreate;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date gmtModified;
}
