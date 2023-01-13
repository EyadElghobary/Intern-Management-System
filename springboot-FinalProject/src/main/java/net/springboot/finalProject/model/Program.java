package net.springboot.finalProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import lombok.Data;

@Data
@Entity
@Table(name="Programs")

public class Program {

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_ID_SEQ")
	@SequenceGenerator(name = "STUDENT_ID_SEQ", sequenceName = "STUDENT_ID_SEQ")
	@Column(name="Program_ID")
	private long id;
    
    @Column(name="Name")
    private String name;

    @Column(name="Description")
    private String description;

    @Column(name="City")
    private String city;

    @Column(name="Country")
    private String country;

    @Column(name="Requirement")
    private String requirements;

    private Date Start_Date;

    private String duration;
    /*
    private Collection<Student> students = new ArrayList<Student>();
    */
}
