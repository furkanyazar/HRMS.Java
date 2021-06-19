package furkanyazar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import furkanyazar.hrms.entities.concretes.Workplace;

public interface WorkplaceDao extends JpaRepository<Workplace, Integer> {
    
}
