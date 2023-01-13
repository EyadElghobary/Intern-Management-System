package net.springboot.finalProject.service;

import java.util.List;

import net.springboot.finalProject.model.Course;
import net.springboot.finalProject.model.Student;
import net.springboot.finalProject.model.University;

public interface StudentService {
	
	// This method is for getting all available students in the program
	List<Student> getAllStudents();
	
	// This method is for getting all Students based on a Course
	List<Student> getStudentsByCourse(Course course);
	
	// This method is for getting all Students based on a University
	List<Student> getStudentsByUni(University university);
	
	// This method is for adding a student
	Student addStudent(Student student);
	
	// This method is for deleting a student
	void deleteStudent(Student student);
	
	// This method is for updating a student, where s1 is old student
	// and s2 is the new updated student 
	Student updateStudent(Student s1, Student s2);
}
