package com.superface.example.dao.impl;

import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.superface.example.dao.StudentDao;
import com.superface.example.entity.Student;
import com.superface.example.repositories.StudentMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * StudentDaoImpl
 */
@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {

    @Resource(name = "mysqlOneJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(Student student) {
        String sql = "insert into student(sno,sname,ssex) values(:sno,:name,:sex)";
		NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
		return npjt.update(sql, new BeanPropertySqlParameterSource(student));
    }

    @Override
    public int update(Student student) {
        String sql = "update student set sname = ?,ssex = ? where sno = ?";
		Object[] args = { student.getName(), student.getSex(), student.getSno() };
		int[] argTypes = { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
		return this.jdbcTemplate.update(sql, args, argTypes);
    }

    @Override
    public int delete(String id) {
        String sql = "delete from student where sno = ?";
		Object[] args = { id };
		int[] argTypes = { Types.VARCHAR };
		return this.jdbcTemplate.update(sql, args, argTypes);
    }

    @Override
    public List<Map<String,Object>> findList() {
        String sql = "select * from student";
		return this.jdbcTemplate.queryForList(sql);
    }

    @Override
    public Student findById(String id) {
        String sql = "select * from student where sno = ?";
		Object[] args = { id };
		int[] argTypes = { Types.VARCHAR };
		List<Student> studentList = this.jdbcTemplate.query(sql, args, argTypes, new StudentMapper());
		if (studentList != null && studentList.size() > 0) {
			return studentList.get(0);
		} else {
			return null;
		}
    }

    
}