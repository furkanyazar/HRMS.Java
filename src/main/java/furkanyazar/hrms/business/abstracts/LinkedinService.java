package furkanyazar.hrms.business.abstracts;

import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.Linkedin;
import furkanyazar.hrms.entities.concretes.User;

public interface LinkedinService {
	
	Result add(Linkedin linkedin, User user);

	DataResult<Linkedin> findByUserId(int userId);

	Result edit(String linkedin, int id);

}
