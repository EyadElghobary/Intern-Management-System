package net.springboot.finalProject.model;


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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "COURSES")
public class Course {

	// Acronym will be the Course_ID
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@SequenceGenerator(name = "COURSE_ID_SEQ", sequenceName = "COURSE_ID_SEQ")
	@Column(name = "course_id")
	// ======== We shouldn't show this on our database.
	private long course_id;

	@Column(name = "Acronym")
	private String acronym;

	@Column(name = "Course_Name")
	private String name;

	@Column(name = "Area")
	private String area;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "University_ID")
	private University university;

	@JsonIgnore()
	@OneToMany(mappedBy = "course")
	private List<StudentCourse> studentCourse = new ArrayList<StudentCourse>();


}
