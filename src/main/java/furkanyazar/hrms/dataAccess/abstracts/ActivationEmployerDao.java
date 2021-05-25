package furkanyazar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import furkanyazar.hrms.entities.concretes.ActivationEmployer;

public interface ActivationEmployerDao extends JpaRepository<ActivationEmployer, Integer>  {
	
}
