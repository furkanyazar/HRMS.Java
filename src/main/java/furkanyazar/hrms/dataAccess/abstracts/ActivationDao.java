package furkanyazar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import furkanyazar.hrms.entities.concretes.Activation;

public interface ActivationDao extends JpaRepository<Activation, Integer> {
	
}
