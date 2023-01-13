package net.springboot.finalProject.model;


import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Students")
public class Student implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_ID_SEQ")
	@SequenceGenerator(name = "STUDENT_ID_SEQ", sequenceName = "STUDENT_ID_SEQ")
	@Column(name="Student_ID")
	private long student_id;
	
	private String name;
	
	//This needs to be changed to resume and should be an upload
	private String enrolment;
	
	@Column(name="DOB")
	private Date dob;
	
	private long year_of_enrolment;
	
	/* The situation variable indicates whether the student got accepted into an internship;
	Situation will be a number that is 0 for no and 1 for yes */
	@Column(name="Situation")
	private int situation;

	// @JsonIgnore
	@OneToMany(mappedBy = "student")
	private List<StudentCourse> studentCourse = new ArrayList<StudentCourse>();

	// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne
	private University university;

	// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne
	@JoinColumn(name="STUDENT_PROGRAM_ID")
	private Program program;

	
}
