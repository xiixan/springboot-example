package com.superface.example.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.superface.example.entity.Student;

import org.springframework.jdbc.core.RowMapper;

/**
 * StudentMapper
 */
public class StudentMapper implements RowMapper<Student> {

    @Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setSno(rs.getString("sno"));
		student.setName(rs.getString("sname"));
		student.setSex(rs.getString("ssex"));
		return student;
	}

}