package com.wheeldestiny.springbootno_1.bean;

public class JobOffersList {
    private Long jobOffersId;//主键id
    private String enterpriseName;//企业名称
    private String recruitmentPositionName;//招聘岗位名称
    private String location;//所在地
    private String industry;//所处行业
    private int numberOfPeople;//人数规模，1表示49人以下，2表示50-99人，3表示100-499人，4表示500-999人，5表示1000-9999，6表示10000人以上
    private String salary;//薪资水平,1表示10-15k，2表示15-25k，3表示20-35k，4表示30-50k，5表示50k以上(面议)
    private int experience;//工作经验，0表示不限，1表示10年及以上，2表示5-10年，3表示3-5年，4表示1-3年
    private int educationalBackground;//学历要求,0表示不限，1表示博士及以上，2表示硕士，3表示本科，4表示专科
    private String skillsName;//所需技术
    private int isdelete;//删除标记

    public Long getJobOffersId() {
        return jobOffersId;
    }

    public void setJobOffersId(Long jobOffersId) {
        this.jobOffersId = jobOffersId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getRecruitmentPositionName() {
        return recruitmentPositionName;
    }

    public void setRecruitmentPositionName(String recruitmentPositionName) {
        this.recruitmentPositionName = recruitmentPositionName;
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

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getEducationalBackground() {
        return educationalBackground;
    }

    public void setEducationalBackground(int educationalBackground) {
        this.educationalBackground = educationalBackground;
    }

    public String getSkillsName() {
        return skillsName;
    }

    public void setSkillsName(String skillsName) {
        this.skillsName = skillsName;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }
}
