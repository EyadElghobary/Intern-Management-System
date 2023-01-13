package net.springboot.finalProject.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;


/**
 * 
 */
@Data
@Embeddable
public class StudentCourseKey implements Serializable{

    public StudentCourseKey(long s_id, long c_id) {
        this.s_id = s_id;
        this.c_id = c_id;
    }

    @Column(name="student_id")
    private long s_id;

    @Column(name="course_id")
    private long c_id;

}