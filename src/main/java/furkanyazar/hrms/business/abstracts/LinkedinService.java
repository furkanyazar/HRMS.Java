package furkanyazar.hrms.business.abstracts;

import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.Linkedin;

public interface LinkedinService {
	
	Result add(Linkedin linkedin);

	DataResult<Linkedin> findByUserId(int userId);

}
