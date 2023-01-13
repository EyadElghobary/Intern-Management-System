package net.springboot.finalProject.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.springboot.finalProject.model.University;
import net.springboot.finalProject.repository.UniversityRepository;

@Service
@Transactional
public class UniversityServiceImpl {

	@Autowired
	private UniversityRepository universityRepository;

	public UniversityServiceImpl(UniversityRepository universityrepository) {
	 	this.universityRepository = universityrepository;
	}

	public List<University> getAllUniversities() {
		// The method gets all the Universities
	 	return this.universityRepository.findAll();
	}

	public List<University> getUniversitiesByState(String state) {
		// This method returns all the Universities given a state.
		return this.universityRepository.findUniverisitesByState(state);
	}

	public List<University> getUniversitiesByCity(String city) {
		// This methord returns all the Universities given a city.
		return this.universityRepository.findUniverisitesByCity(city);
	}

	public University addUniversity(University university) {
		// This method add a University.
	 	return this.universityRepository.save(university);
	}

	public void deleteUniversity(long university_id) {
		// This method delete a university.
		this.universityRepository.deleteById(university_id);
	}

	public University findUni(University university) {
		List<University> universities = this.universityRepository.getUniByNameLocation(university.getName(), 
		university.getLocation().getCity(), university.getLocation().getAddress());
		for (University uni: universities) {
			if (universities.size() != 0) {
				return uni;
			}
		}
		return null;
	}

}
