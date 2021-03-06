package com.shadow.blog.entity;

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
@TableName("blog_user")
public class UserDO {
  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private String id;
  private String username;
  private String password;
  private String ip;
  private String avatar;
  private Boolean freeze;
  private Date freezeDate;
  private Boolean delete;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private String lastLoginTime;
  private String linkId;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private String gmtCreate;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private String gmtModified;
}
