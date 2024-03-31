package com.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.student.dao.StudentDao;
import com.student.model.Student;
import com.student.services.Services;

@Service
public class StudentServiceImpl implements Services {
	@Autowired
	private StudentDao studentDao;

	@Override
	public List<Student> getStudents() {
		
		return studentDao.findAll();
	}

	@Override
	public Student getStudent(Integer studentId) {
		// TODO Auto-generated method stub
		return studentDao.getOne(studentId);
	}

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDao.save(student);
	}

	@Override
	public Student updateStudent(Student student, Integer studentId) {
		// TODO Auto-generated method stub
		studentDao.save(student);
		return student;
	}

	@Override
	public void deleteStudent(Integer studentId) {
		// TODO Auto-generated method stub
		Student en  = studentDao.getById(studentId);
		studentDao.delete(en);
		
	}

}
