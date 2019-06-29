package com.allen.springBoot.launch;

import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan("com.allen.springBoot.*") //组件包扫描路径
@MapperScan("com.allen.springBoot.mybatis.dao.mapper")//扫描mybatis mapper接口所在包
public class MyApplication  {

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}



}
