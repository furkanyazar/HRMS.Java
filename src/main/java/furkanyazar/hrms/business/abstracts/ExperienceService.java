package furkanyazar.hrms.business.abstracts;

import java.util.List;

import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.Experience;

public interface ExperienceService {

	DataResult<List<Experience>> findByUserIdOrderByEndingDateDesc(int userId);

	Result add(Experience experience);

}
