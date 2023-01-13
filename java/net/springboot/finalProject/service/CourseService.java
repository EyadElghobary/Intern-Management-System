package net.springboot.finalProject.service;

import java.util.List;

import net.springboot.finalProject.model.Course;
import net.springboot.finalProject.model.University;

public interface CourseService {
	
	// This method returns all courses from all Universities in the program
	List<Course> getAllCourses();
	
	// This method returns all courses in a given University
	List<Course> getCoursesByUni(University university);
	
	// This method returns all courses in a given area
	List<Course> getCoursesByArea(String area);
	
	// This method returns all courses with a given acronym
	List<Course> getCoursesByAcronym(String acronym);
	
	// This method adds a course to the list of courses
	Course addCourse(Course course);
	
	// This method allows for a course to be deleted only if the
	// the course contained one student and deleteStudent() was called.
	void deleteCourse(Course course);
}
