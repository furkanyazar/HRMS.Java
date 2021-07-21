package furkanyazar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import furkanyazar.hrms.entities.concretes.Update;

public interface UpdateDao extends JpaRepository<Update, Integer> {

    Update findByUserId(int userId);
    
}
