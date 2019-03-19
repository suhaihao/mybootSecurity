package com.mytt.boot.Moudel;



import java.io.Serializable;
import java.math.BigDecimal;

public class OsImages implements Serializable {

    private String id;// id
    private String name;// 名称
    private String url;// 路径
    private String type;// 图片类型
    private String width;// 宽
    private String height;// 高
    private String size;// 大小
    private String keyword;// 关键字
    private String userId;// 图片添加人
    private String userFlag;// 用户前后台标识0 后台 1 前台
    private String isDel;// 是否废除
    private Long utime;// 更新时间
    private String scaleName;// 缩略图名称
    private String scaleUrl;// 缩略图网络地址
    private String scaleLocalurl;// 缩略图本地地址
    private String scaleWidth;// 缩略图宽度
    private String scaleHeight;// 缩略图高度
    private BigDecimal scaleRate;// 缩略图比例
    private String isUsed;
    private String cloudStorage;//云存储平台名称
    private String aliOssInnerUrl;//阿里云存储object内网访问地址

    public String getCloudStorage() {
        return cloudStorage;
    }

    public void setCloudStorage(String cloudStorage) {
        this.cloudStorage = cloudStorage;
    }

    public String getAliOssInnerUrl() {
        return aliOssInnerUrl;
    }

    public void setAliOssInnerUrl(String aliOssInnerUrl) {
        this.aliOssInnerUrl = aliOssInnerUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(String userFlag) {
        this.userFlag = userFlag;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public Long getUtime() {
        return utime;
    }

    public void setUtime(Long utime) {
        this.utime = utime;
    }

    public String getScaleName() {
        return scaleName;
    }

    public void setScaleName(String scaleName) {
        this.scaleName = scaleName;
    }

    public String getScaleUrl() {
        return scaleUrl;
    }

    public void setScaleUrl(String scaleUrl) {
        this.scaleUrl = scaleUrl;
    }

    public String getScaleWidth() {
        return scaleWidth;
    }

    public void setScaleWidth(String scaleWidth) {
        this.scaleWidth = scaleWidth;
    }

    public String getScaleHeight() {
        return scaleHeight;
    }

    public void setScaleHeight(String scaleHeight) {
        this.scaleHeight = scaleHeight;
    }

    public BigDecimal getScaleRate() {
        return scaleRate;
    }

    public void setScaleRate(BigDecimal scaleRate) {
        this.scaleRate = scaleRate;
    }

    public String getScaleLocalurl() {
        return scaleLocalurl;
    }

    public void setScaleLocalurl(String scaleLocalurl) {
        this.scaleLocalurl = scaleLocalurl;
    }

    public String getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed;
    }

}
