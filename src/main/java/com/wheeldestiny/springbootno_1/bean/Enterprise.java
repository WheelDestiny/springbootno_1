package com.wheeldestiny.springbootno_1.bean;
//企业信息实体
public class Enterprise {
    private Long enterpriseId;//企业id
    private String enterpeiseName;//企业名称
    private int numberOfPeople;//人数规模，1表示49人以下，2表示50-99人，3表示100-499人，4表示500-999人，5表示1000-9999，6表示10000人以上
    private String location;//所在地
    private String industry;//所处行业
    private int isdelete;//删除标记

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpeiseName() {
        return enterpeiseName;
    }

    public void setEnterpeiseName(String enterpeiseName) {
        this.enterpeiseName = enterpeiseName;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }
}
