package net.springboot.finalProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.springboot.finalProject.model.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {

    @Query("select p from Program p where p.name = :name")
    public List<Program> findProgramByName(@Param("name") String name);
    
}
