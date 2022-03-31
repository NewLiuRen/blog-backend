package com.shadow.blog.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author L.R
 * @date 2022-3-31 10:36
 */
@Data
public class LinkDO {
  private Integer id;
  private String username;
  private String email;
  private String url;
  private String github;
  private Integer userId;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date gmtCreate;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date gmtModified;
}
