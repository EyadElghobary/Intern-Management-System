package net.springboot.finalProject.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Universities")
public class University {

	// Name should be ID since every university has a different name
	// (ASSUMPTION!!!!)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UNIVERSITY_ID_SEQ")
	@SequenceGenerator(name = "UNIVERSITY_ID_SEQ", sequenceName = "UNIVERSITY_ID_SEQ")
	@Column(name = "University_ID")
	private long id;

	@Column(name = "University_Name")
	private String name;

	@Embedded
	private Location location;

	/*
	@JsonIgnore
	@OneToMany(mappedBy = "university")
	private Collection<Course> courses = new ArrayList<Course>();

	@JsonIgnore
	@OneToMany(mappedBy = "university")
	private Collection<Student> students = new ArrayList<Student>();
	 */

}
