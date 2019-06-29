package com.allen.springBoot.mybatis.dao.mapper;

import com.allen.springBoot.mybatis.dao.model.Student;
import com.allen.springBoot.mybatis.dao.model.StudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    int countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer studentId);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Integer studentId);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<String> getStudentNameByTeacherName(String studentName);

    List<String> getTeacherNameByCityNameAndCollectName(String city, String collegeName);

    List<String> getStudentNoByTeacherNameAndCollectName(String teacherName, String collegeName);
}