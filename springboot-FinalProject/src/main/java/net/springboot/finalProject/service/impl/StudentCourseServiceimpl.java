package net.springboot.finalProject.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import net.springboot.finalProject.model.Course;
import net.springboot.finalProject.model.Student;
import net.springboot.finalProject.model.StudentCourse;
import net.springboot.finalProject.repository.StudentCourseRepository;

@Service
@Transactional
public class StudentCourseServiceimpl {
    
    private StudentServiceImpl studentService;
	private StudentCourseRepository studentcourseRepository;
	private CourseServiceImpl courseService;

    public StudentCourseServiceimpl(StudentServiceImpl studentservice, StudentCourseRepository scr, CourseServiceImpl courseservice) {
        this.studentService = studentservice;
        this.studentcourseRepository = scr;
        this.courseService = courseservice;
    }

    public StudentCourse addStudentCourse(StudentCourse sc) {
        sc.getCourse().setUniversity(sc.getStudent().getUniversity());
        Course course = new Course();
        course = this.courseService.findCourse(sc.getCourse());
        if (course == null) {
            course = this.courseService.addCourse(sc.getCourse());
        }
        sc.setCourse(course);
        return this.studentcourseRepository.save(sc);
    }

    public void deleteStudentCourse(long student_id, long course_id) {
        List<StudentCourse> sc = this.studentcourseRepository.findStudentCourse(course_id, student_id);
        if (sc.size() == 1) {
            this.studentcourseRepository.delete(sc.get(0));
        }
    }

    public List<Course> getStudentCourses(long student_id) {
        // This will take a student_id and use it to get all the courses with
        // the corresponding student_id
		List<StudentCourse> studentcourse = studentcourseRepository.findCourses(student_id);
		List<Course> courses = new ArrayList<Course>();
		for (StudentCourse sc: studentcourse) {
			Optional<Course> course = courseService.findCourseById(sc.getCourse().getCourse_id());
            if (course.isPresent()) {
                courses.add(course.get());
            }
		}
	 	return courses;
	}

    public List<Student> getCourseStudents(long course_id) {
        // This will take a course_id and use it to get all the students
        // with the corresponding course_id
        List<StudentCourse> studentcourse = studentcourseRepository.findStudents(course_id);
		List<Student> students = new ArrayList<Student>();
		for (StudentCourse sc: studentcourse) {
			Student student = studentService.findStudentById(sc.getStudent().getStudent_id());
            students.add(student);
		}
	 	return students;

    }


}

