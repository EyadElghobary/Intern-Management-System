package net.springboot.finalProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.springboot.finalProject.exception.ResourceNotFoundException;
import net.springboot.finalProject.model.Program;
import net.springboot.finalProject.model.Student;
import net.springboot.finalProject.model.University;
import net.springboot.finalProject.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl {
	// None of the methods should have the Override keyword annotation
	
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private UniversityServiceImpl universityService;
	@Autowired
	private ProgramServiceImpl programService;

	public StudentServiceImpl(StudentRepository studentrepository) {
	 	this.studentRepository = studentrepository;
	}

	public List<Student> getAllStudents() {
		return this.studentRepository.findAll();
	}

	public List<Student> getStudentsByUni(long university_id) {
		// Gets all students that have the given university_id
	 	return this.studentRepository.findUniversityStudents(university_id);
	}

	public Student addStudent(Student student) {
		Program program = new Program();
		program = this.programService.getProgramByName(student.getProgram().getName());
		if (program == null ) {
			program = this.programService.addProgram(student.getProgram());
		} 
		student.setProgram(program);

		University university = new University();
		university = this.universityService.findUni(student.getUniversity());
		if (university == null) {
			university = this.universityService.addUniversity(student.getUniversity());
		}
		student.setUniversity(university);

		boolean flag = false;

		for (Student s: this.getAllStudents()) {
			if (student.getName().equals(s.getName()) && student.getProgram().equals(s.getProgram()) &&
			student.getUniversity().equals(s.getUniversity())) {
				flag = true;
			}
		}

		if (!flag) {
			return this.studentRepository.save(student);
		}
		return this.studentRepository.save(student);
	}

	public void deleteStudent(long student_id) {
		// Try use the Exception class for this method in the
		// the case the you don't find the required student.
		this.studentRepository.deleteById(student_id);

	}

	public Student updateStudent(Student s1, long student_id) {
	 	// Try use the Exception class for this method in the
		// the case the you don't find the required student.
		Student s = this.studentRepository.findById(student_id).orElseThrow(() -> new RuntimeException());
		s.setName(s1.getName());
		s.setUniversity(s1.getUniversity());
		// s.setCourses(s1.getCourses());
		s.setEnrolment(s1.getEnrolment());
		s.setYear_of_enrolment(s1.getYear_of_enrolment());
		s.setDob(s1.getDob());
		s.setSituation(s1.getSituation());
		return s;

	}

	public boolean findStudent(Student student) {
		List<Student> students = this.getAllStudents();
		for (Student s: students) {
			if (student.equals(s)) {
				return true;
			}
		}
		return false;
	}

	public Student findStudentById(long student_id) {
		return this.studentRepository.findById(student_id).orElseThrow(() -> new ResourceNotFoundException("student", "id", student_id));
	}
	
}
