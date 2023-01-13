package net.springboot.finalProject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import net.springboot.finalProject.model.Course;
import net.springboot.finalProject.model.Student;
import net.springboot.finalProject.model.StudentCourse;
import net.springboot.finalProject.service.impl.CourseServiceImpl;
import net.springboot.finalProject.service.impl.StudentCourseServiceimpl;
import net.springboot.finalProject.service.impl.StudentServiceImpl;
import net.springboot.finalProject.service.impl.UniversityServiceImpl;

@RestController
@Data
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:4200/")
public class StudentController {
    
    private StudentServiceImpl studentService;
    private CourseServiceImpl courseService;
    private UniversityServiceImpl universityService;
    private StudentCourseServiceimpl studentcourseService;

    public StudentController(StudentServiceImpl studentService, CourseServiceImpl courseService, UniversityServiceImpl universityService, StudentCourseServiceimpl studentCourseService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.universityService = universityService;
        this.studentcourseService = studentCourseService;
    }

    @PostMapping("/new/student")
    public void addStudent(@RequestBody Student s) {
        // return new ResponseEntity<Student>(this.studentService.addStudent(s), HttpStatus.CREATED);
        // You need to check here if StudentCourse can be entered more than once

        // Here what we do, assuming that after we implement the angular section and the variable
        // s (Student) contains the required information that we do this:
        // this.universityRepository.addUniversity(s.getUniversity()) - where this line due to the
        // cascade will add an entry to the student and course table.
        // this.studentRepository.addStudent(s) - this line updates the studentCourseRepo
        // ????
        this.studentService.addStudent(s);
        for (StudentCourse sc: s.getStudentCourse()) {
            sc.setStudent(s);
            this.studentcourseService.addStudentCourse(sc);
        }
        // return "New Student Added";

    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") long student_id) {
        Student student = this.studentService.findStudentById(student_id);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @DeleteMapping("/delete/student/{id}")
	public String deleteStudent(@PathVariable(name="id") long id) {

        // First few lines are for ensuring that the appropriate courses and records
        // are deleted.
        List<Course> courses = this.studentcourseService.getStudentCourses(id);
		for (Course course: courses) {
            this.studentcourseService.deleteStudentCourse(id, course.getCourse_id());
            if (this.studentcourseService.getCourseStudents(course.getCourse_id()).size() <= 1) {

                this.courseService.deleteCourse(course.getCourse_id());
            }
        }

        Student student = this.studentService.findStudentById(id);
        long uni_id = student.getUniversity().getId();
        List<Student> students = this.studentService.getStudentsByUni(uni_id);
        this.studentService.deleteStudent(id);
        if (students.size() <= 1) {
            this.universityService.deleteUniversity(uni_id);

        }
        
        // this.studentService.deleteStudent(id);
        System.out.println("\n---------Student got deleted---------\n");
        return "Student deleted";
	}

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return new ResponseEntity<List<Student>>(this.studentService.getAllStudents(), HttpStatus.OK);
    }

    


}
