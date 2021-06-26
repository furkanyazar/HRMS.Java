package furkanyazar.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import furkanyazar.hrms.entities.concretes.ActivationEmployer;

public interface ActivationEmployerDao extends JpaRepository<ActivationEmployer, Integer>  {
	
    ActivationEmployer getByUserId(int id);

    List<ActivationEmployer> findByIsActivated(Boolean isActivated);

    ActivationEmployer findByIsActivatedAndUser_EmailAndUser_Password(Boolean isActivated, String email, String password);

}
