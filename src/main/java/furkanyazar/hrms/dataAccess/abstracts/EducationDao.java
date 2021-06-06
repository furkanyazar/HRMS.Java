package furkanyazar.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import furkanyazar.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer> {
	
	List<Education> findByUserIdOrderByEndingDateDesc(int userId);

	List<Education> findByUserId(int userId);

}
