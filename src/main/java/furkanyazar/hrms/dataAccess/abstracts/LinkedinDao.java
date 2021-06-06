package furkanyazar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import furkanyazar.hrms.entities.concretes.Linkedin;

public interface LinkedinDao extends JpaRepository<Linkedin, Integer> {

    Linkedin findByUserId(int userId);

}
