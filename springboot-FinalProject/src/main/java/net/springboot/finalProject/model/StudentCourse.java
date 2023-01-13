package net.springboot.finalProject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class StudentCourse {
    /*
    @EmbeddedId
    private StudentCourseKey id;
     */

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private long sc_id;
    
    @JsonIgnore
    @ManyToOne
    // @MapsId("s_id")
    @JoinColumn(name = "STUDENT_ID")
    private Student student;

    // @JsonIgnore
    @ManyToOne
    // @MapsId("c_id")
    @JoinColumn(name = "COURSE_ID")
    private Course course;
    

}