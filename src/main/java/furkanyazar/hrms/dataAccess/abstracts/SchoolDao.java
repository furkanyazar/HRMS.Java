package furkanyazar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import furkanyazar.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer> {
    
}
