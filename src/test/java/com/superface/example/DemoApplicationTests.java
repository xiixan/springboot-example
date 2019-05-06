package com.superface.example;

import javax.annotation.Resource;

import com.superface.example.entity.Student;
import com.superface.example.service.StudentService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Resource
	private StudentService studentService;

	@Test
	public void contextLoads() {
		Student student1 = this.studentService.findById("001");
        System.out.println("学号" + student1.getSno() + "的学生姓名为：" + student1.getName());
        
        Student student2 = this.studentService.findById("001");
        System.out.println("学号" + student2.getSno() + "的学生姓名为：" + student2.getName());
	}

}
