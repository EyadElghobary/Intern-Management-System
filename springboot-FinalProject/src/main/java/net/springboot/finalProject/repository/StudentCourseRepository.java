package net.springboot.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import net.springboot.finalProject.model.StudentCourse;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long>{

    
    @Query("SELECT sc FROM StudentCourse sc WHERE sc.student.student_id = :id")
	List<StudentCourse> findCourses(@Param("id") long student_id);

    @Query("SELECT sc FROM StudentCourse sc WHERE sc.course.course_id = :id")
	List<StudentCourse> findStudents(@Param("id") long course_id);
    
    @Query("SELECT sc FROM StudentCourse sc WHERE sc.course.course_id = :c_id and sc.student.student_id = :s_id")
    List<StudentCourse> findStudentCourse(@Param("c_id") long course_id, @Param("s_id") long student_id);
}