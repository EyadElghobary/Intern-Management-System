package net.springboot.finalProject.service;

import java.util.List;

import net.springboot.finalProject.model.University;

public interface UniversityService {
	
	// This method returns a list of all universities in the program
	List<University> getAllUniversities();
	
	// This method returns all universities in a given state
	List<University> getUniversitiesByState(String state);
	
	// This method returns all universites in a given city
	List<University> getUniversitiesByCity(String city);
	
	// This method allows for a university to be added
	University addUniversity(University university);
	
	// This method allows for a university to be deleted only if the
	// the university contained one student and deleteStudent() was called.
	void deleteUniversity(University university);
}
