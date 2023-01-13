package net.springboot.finalProject.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import net.springboot.finalProject.model.Program;
import net.springboot.finalProject.repository.ProgramRepository;

@Service
@Transactional
public class ProgramServiceImpl {

    private ProgramRepository programRepository;

    public ProgramServiceImpl(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    public List<Program> getAllPrograms() {
        return this.programRepository.findAll();
    }

    public Program addProgram(Program program) {
        return this.programRepository.save(program);
    }

    public void deleteProgram(long program_id) {
        this.programRepository.deleteById(program_id);
    }

    public Program getProgramByName(String name) {
        // We are assuming that all programs are to the same company and so the name
        // of every program is different
        /*
		List<Program> programs = this.getAllPrograms();
		for (Program p: programs) {
			if (program.getName().equals(p.getName())) {
				return true;
			}
		}
		return false;
        */
        List<Program> programs = this.programRepository.findProgramByName(name);
        if (programs.size() < 1) {
            return null;
        }
        return programs.get(0);
        
	}  
}
