package com.wheeldestiny.springbootno_1.bean;

public class JobOffers {
    private Long jobOffersId;//招聘信息id
    private Long enterpriseId;//企业id
    private Long recruitmentPositionId;//招聘岗位id
    private String salary;//薪资水平,1表示10-15k，2表示15-25k，3表示20-35k，4表示30-50k，5表示50k以上(面议)
    private int experience;//工作经验，0表示不限，1表示10年及以上，2表示5-10年，3表示3-5年，4表示1-3年
    private String extraSkills;//额外需要的技能id(加分项)，用","隔开，前后无","
    private int eductionBackground;//学历要求,0表示不限，1表示博士及以上，2表示硕士，3表示本科，4表示专科
    private int isdelete;//删除标记

    public Long getJobOffersId() {
        return jobOffersId;
    }

    public void setJobOffersId(Long jobOffersId) {
        this.jobOffersId = jobOffersId;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Long getRecruitmentPositionId() {
        return recruitmentPositionId;
    }

    public void setRecruitmentPositionId(Long recruitmentPositionId) {
        this.recruitmentPositionId = recruitmentPositionId;
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

    public String getExtraSkills() {
        return extraSkills;
    }

    public void setExtraSkills(String extraSkills) {
        this.extraSkills = extraSkills;
    }

    public int getEductionBackground() {
        return eductionBackground;
    }

    public void setEductionBackground(int eductionBackground) {
        this.eductionBackground = eductionBackground;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }
}
