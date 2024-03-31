package com.student.services;

import java.util.List;


import com.student.model.Student;

public interface Services {
	public List<Student> getStudents();
	
	public Student getStudent(Integer studentId);
	
	public Student addStudent(Student student);
	
	public Student updateStudent(Student student, Integer studentId);
	
	public void deleteStudent( Integer studentId);

}
