package furkanyazar.hrms.business.abstracts;

import java.util.List;

import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.Education;

public interface EducationService {
	
	DataResult<List<Education>> findByUserIdOrderByEndingDateDesc(int userId);

	DataResult<List<Education>> findByUserId(int userId);

	DataResult<Education> findById(int id);
	
	Result add(Education education);

	Result remove(int id);

}
