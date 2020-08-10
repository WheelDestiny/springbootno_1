package com.wheeldestiny.springbootno_1.bean;

//需求技术实体
public class Skill {
    private Long skillId;//技术id
    private String skillName;//技术名称
    private int skillType;//技能类型：1编程语言，2操作系统，3开发工具，4生产工具，5生态圈，6编程思想，7算法基础，8业务逻辑，9团队管理，10底层调优，0其他
    private Long skillParentId;//父级技术id
    private int isdelete;//删除标记

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getSkillType() {
        return skillType;
    }

    public void setSkillType(int skillType) {
        this.skillType = skillType;
    }

    public Long getSkillParentId() {
        return skillParentId;
    }

    public void setSkillParentId(Long skillParentId) {
        this.skillParentId = skillParentId;
    }

    public int getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }
}
