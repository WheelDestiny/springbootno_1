package com.wheeldestiny.springbootno_1.bean;

//招聘岗位
public class RecruitmentPosition {
    private Long recruitmentPositionId;//招聘岗位id
    private String recruitmentPositionName;//招聘岗位名称
    private String skills;//岗位需要的技能id，用id间用","隔开，前后无","
    private int isdelete;//删除标记

    public Long getRecruitmentPositionId() {
        return recruitmentPositionId;
    }

    public void setRecruitmentPositionId(Long recruitmentPositionId) {
        this.recruitmentPositionId = recruitmentPositionId;
    }

    public String getRecruitmentPositionName() {
        return recruitmentPositionName;
    }

    public void setRecruitmentPositionName(String recruitmentPositionName) {
        this.recruitmentPositionName = recruitmentPositionName;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }
}
