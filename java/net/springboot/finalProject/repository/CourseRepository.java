package net.springboot.finalProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.springboot.finalProject.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

    @Query("from Course c where c.university.id = :id")
    List<Course> findCoursesByUniversity(@Param("id") long university_id);

    @Query("select c from Course c where UPPER(c.area) = UPPER(:area)")
    List<Course> findCoursesByArea(@Param("area") String area);

    @Query("select c from Course c where UPPER(c.acronym) = UPPER(:acronym)")
    List<Course> findCoursesByAcronym(@Param("acronym") String acronym);

    @Query("select c from Course c where c.university.id = :id and UPPER(c.acronym) = UPPER(:acronym)")
    List<Course> getCourse(@Param("id") long id, @Param("acronym") String acronym);

}
