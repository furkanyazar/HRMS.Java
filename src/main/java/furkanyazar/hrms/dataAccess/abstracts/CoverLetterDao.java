package furkanyazar.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import furkanyazar.hrms.entities.concretes.CoverLetter;

public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer> {

    CoverLetter findByUserId(int userId);

}
