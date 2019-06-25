package com.oneplatform.cms.dto.param;

import io.swagger.annotations.ApiModelProperty;

/**
 * generated by www.jeesuite.com
 */
public class ArticleParam{

    @ApiModelProperty("属性名")
    private Integer id;
    
    @ApiModelProperty("标题")
    private String title;
    
    @ApiModelProperty("属性名")
    private String cover;
    
    @ApiModelProperty("属性名")
    private String summary;
    
    @ApiModelProperty("内容")
    private String content;
    
    @ApiModelProperty("属性名")
    private Integer categoryId;
    
    @ApiModelProperty("浏览数")
    private Integer viewCount;
    
    @ApiModelProperty("评论数")
    private Integer commentCount;
    
    @ApiModelProperty("点赞数")
    private Integer likeCount;
    
    @ApiModelProperty("是否审核")
    private Boolean audited;
    
    @ApiModelProperty("属性名")
    private Integer createdBy;
    
    @ApiModelProperty("属性名")
    private java.util.Date createdAt;
    
    @ApiModelProperty("属性名")
    private Integer updatedBy;
    
    @ApiModelProperty("属性名")
    private java.util.Date updatedAt;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }
    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }
    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }
    public Boolean getAudited() {
        return audited;
    }

    public void setAudited(Boolean audited) {
        this.audited = audited;
    }
    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
    public java.util.Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.util.Date createdAt) {
        this.createdAt = createdAt;
    }
    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }
    public java.util.Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(java.util.Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}