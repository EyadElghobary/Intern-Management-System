package net.springboot.finalProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.springboot.finalProject.model.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long>{

    @Query("select u from University u where UPPER(u.location.state) = UPPER(:state)")
    List<University> findUniverisitesByState(@Param("state") String state);

    @Query("select u from University u where UPPER(u.location.city) = UPPER(:city)")
    List<University> findUniverisitesByCity(@Param("city") String city);

    @Query("select u from University u where UPPER(u.name) = UPPER(:name) and UPPER(u.location.city) = UPPER(:city) and UPPER(u.location.address) = UPPER(:address)")
    List<University> getUniByNameLocation(@Param("name") String name, @Param("city") String city, @Param("address") String address);

}
