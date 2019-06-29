package com.allen.springBoot.mybatis.dao.model;

import java.io.Serializable;

public class Student implements Serializable {
    /**
     * 学生id
     *
     * @mbggenerated
     */
    private Integer studentId;

    /**
     * 学号
     *
     * @mbggenerated
     */
    private String studentNo;

    /**
     * 学生姓名
     *
     * @mbggenerated
     */
    private String studentName;

    /**
     * 教师id
     *
     * @mbggenerated
     */
    private Integer teacherId;

    /**
     * 学院id
     *
     * @mbggenerated
     */
    private Integer collegeId;

    private static final long serialVersionUID = 1L;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public Student() {
    }

    public Student(String studentNo, String studentName, Integer teacherId, Integer collegeId) {
        this.studentNo = studentNo;
        this.studentName = studentName;
        this.teacherId = teacherId;
        this.collegeId = collegeId;
    }

    public Student(Integer studentId, String studentNo, String studentName, Integer teacherId, Integer collegeId) {
        this.studentId = studentId;
        this.studentNo = studentNo;
        this.studentName = studentName;
        this.teacherId = teacherId;
        this.collegeId = collegeId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", studentId=").append(studentId);
        sb.append(", studentNo=").append(studentNo);
        sb.append(", studentName=").append(studentName);
        sb.append(", teacherId=").append(teacherId);
        sb.append(", collegeId=").append(collegeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}