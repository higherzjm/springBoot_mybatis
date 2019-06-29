package com.allen.springBoot.controller;

import com.allen.springBoot.mybatis.dao.mapper.StudentMapper;
import com.allen.springBoot.mybatis.dao.mapper.TeacherMapper;
import com.allen.springBoot.mybatis.dao.model.Student;
import com.allen.springBoot.mybatis.dao.model.StudentExample;
import com.allen.springBoot.mybatis.dao.model.Teacher;
import com.allen.springBoot.mybatis.dao.model.TeacherExample;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MyController {


    //测试mybatis的自动生成的mapper操作 begin
	@Resource
	public StudentMapper studentMapper;

	/**
	 * 查询所有学生信息
	 *  http://localhost:8080/getAllStudents
	 */
	@GetMapping("/getAllStudents")
	@ResponseBody
	public List<Student> getAllStudents(){
		StudentExample studentExample = new StudentExample();
		StudentExample.Criteria studentExampleCriteria = studentExample.createCriteria();
		List<Student> students= studentMapper.selectByExample(studentExample);
		return students;
	}

	/**
	 * 添加新的学生
	 *  http://localhost:8080/addNewStudent
	 */
	@GetMapping("/addNewStudent")
	@ResponseBody
	public String addNewStudent(){
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("ss");
		String randomNum=simpleDateFormat.format(new Date());

		StudentExample studentExample = new StudentExample();
		StudentExample.Criteria studentExampleCriteria = studentExample.createCriteria();
		Student student=new Student("10009"+randomNum,"李四9"+randomNum,7,1);
		try {
			studentMapper.insert(student);
			return "添加成功  ";
		}catch (Exception e){
			e.printStackTrace();
			return "添加异常:"+e.getMessage();
		}
	}

	/**
	 * 更新学生信息
	 *  http://localhost:8080/updateStudentInfo
	 */
	@GetMapping("/updateStudentInfo")
	@ResponseBody
	public String updateStudentInfo(){
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("ss");
		String randomNum=simpleDateFormat.format(new Date());
		Student student=new Student(14,"1000988","李四999"+randomNum,7,1);
		try {
			studentMapper.updateByPrimaryKeySelective(student);//更新方法1，按主键更新

			StudentExample studentExample = new StudentExample();
			StudentExample.Criteria studentExampleCriteria = studentExample.createCriteria();
			studentExampleCriteria.andStudentNoEqualTo("1000999");
			student=new Student("1000999","李四998"+randomNum,7,1);
			studentMapper.updateByExampleSelective(student,studentExample);//更新方法2，按条件更新
			return "更新成功";
		}catch (Exception e){
			e.printStackTrace();
			return "更新异常:"+e.getMessage();
		}
	}
	/**
	 * 通过学号删除学生
	 *  http://localhost:8080/deleteStudentByNo/1000999
	 */
	@GetMapping("/deleteStudentByNo/{studentNo}")
	@ResponseBody
	public String deleteStudentByNo(@PathVariable(value = "studentNo") String studentNo){
		StudentExample studentExample = new StudentExample();
		StudentExample.Criteria studentExampleCriteria = studentExample.createCriteria();
		studentExampleCriteria.andStudentNoEqualTo(studentNo);
		try {
			studentMapper.deleteByExample(studentExample);
			return "删除成功";
		}catch (Exception e){
			e.printStackTrace();
			return "删除异常:"+e.getMessage();
		}
	}
	//测试mybatis的自动生成的mapper操作 end


	//测试mybatis的自定义的mapper脚本操作 begin
	/**
	 *通过教师的名字获取学生的名字
	 * http://localhost:8080/getStudentNameByTeacherName/张三1
	 * @return
	 */
	@GetMapping( "/getStudentNameByTeacherName/{teacherName}")
	@ResponseBody
	public List<String> getTeacherNameByStudentName(@PathVariable(value = "teacherName") String teacherName) {

		List<String> listStudent=studentMapper.getStudentNameByTeacherName(teacherName);
		return listStudent;
	}


	/**
	 * 查询祖籍为龙岩市计算机学院的老师姓名
	 *  http://localhost:8080/getTeacherNameByCityNameAndCollectName/龙岩市/计算机学院
	 */
	@GetMapping("/getTeacherNameByCityNameAndCollectName/{city}/{collegeName}")
	@ResponseBody
	public List<String>  getTeacherNameByCityNameAndCollectName(@PathVariable(value = "city") String city,@PathVariable(value = "collegeName") String collegeName){
		List<String> teacherNames=studentMapper.getTeacherNameByCityNameAndCollectName(city,collegeName);
		return teacherNames;
	}

	/**
	 * 查询计算机学院下张三1老师带的学生学号
	 *  http://localhost:8080/getStudentNoByTeacherNameAndCollectName/张三1/计算机学院
	 */
	@GetMapping("/getStudentNoByTeacherNameAndCollectName/{teacherName}/{collegeName}")
	@ResponseBody
	public List<String>  getStudentNoByTeacherNameAndCollectName(@PathVariable(value = "teacherName") String teacherName,@PathVariable(value = "collegeName") String collegeName){
		List<String> studentNos=studentMapper.getStudentNoByTeacherNameAndCollectName(teacherName,collegeName);
		return studentNos;
	}
	//测试mybatis的自定义的mapper脚本操作 end
}
