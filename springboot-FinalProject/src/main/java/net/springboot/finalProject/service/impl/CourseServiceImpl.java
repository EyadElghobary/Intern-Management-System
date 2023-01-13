package net.springboot.finalProject.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.springboot.finalProject.model.Course;
import net.springboot.finalProject.repository.CourseRepository;

@Service
@Transactional
public class CourseServiceImpl {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public CourseServiceImpl(CourseRepository courserepository) {
	 	this.courseRepository = courserepository;
	}

	public List<Course> getAllCourses() {
	 	return this.courseRepository.findAll();
	}

	public List<Course> getCoursesByUni(long university_id) {
	 	return this.courseRepository.findCoursesByUniversity(university_id);
	}

	public List<Course> getCoursesByArea(String area) {
	 	// TODO Auto-generated method stub
	 	return this.courseRepository.findCoursesByArea(area);
	}

	public List<Course> getCoursesByAcronym(String acronym) {
	 	// TODO Auto-generated method stub
		return this.courseRepository.findCoursesByAcronym(acronym);
	}

	public Course addCourse(Course course) {
		return this.courseRepository.save(course);
	}

	
	public void deleteCourse(long course_id) {
		this.courseRepository.deleteById(course_id);
	}

	public Course findCourse(Course course) {
		List<Course> courses = this.courseRepository.getCourse(course.getUniversity().getId(), course.getAcronym());
		if (courses.size() == 0) {
			return null;
		}
		return courses.get(0);
	}

	public Optional<Course> findCourseById(long course_id) {
		return this.courseRepository.findById(course_id);
	}

}
