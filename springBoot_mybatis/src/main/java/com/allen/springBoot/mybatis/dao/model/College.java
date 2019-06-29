package com.allen.springBoot.mybatis.dao.model;

import java.io.Serializable;

public class College implements Serializable {
    /**
     * 学院id
     *
     * @mbggenerated
     */
    private Integer collegeId;

    /**
     * 学院名称
     *
     * @mbggenerated
     */
    private String colegeName;

    private static final long serialVersionUID = 1L;

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public String getColegeName() {
        return colegeName;
    }

    public void setColegeName(String colegeName) {
        this.colegeName = colegeName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", collegeId=").append(collegeId);
        sb.append(", colegeName=").append(colegeName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}