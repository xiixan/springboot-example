package com.superface.example.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.superface.example.annotation.Log;
import com.superface.example.dao.StudentDao;
import com.superface.example.entity.Student;
import com.superface.example.service.StudentService;

import org.springframework.stereotype.Service;

/**
 * StudentServiceImpl
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Resource(name = "studentDao")
	private StudentDao studentDao;

	@Override
	public int add(Student student) {
		return this.studentDao.add(student);
	}

	@Override
	public int update(Student student) {
		return this.studentDao.update(student);
	}

	@Override
	public int delete(String id) {
		return this.studentDao.delete(id);
	}

	@Override
	//@Log("Service")
	public List<Map<String, Object>> findList() {
		return this.studentDao.findList();
	}

	@Override
	public Student findById(String id) {
		return this.studentDao.findById(id);
	}
}