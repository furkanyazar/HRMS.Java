package furkanyazar.hrms.business.abstracts;

import java.util.List;

import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.ActivationEmployer;
import furkanyazar.hrms.entities.concretes.User;

public interface ActivationEmployerService {
	
	DataResult<List<ActivationEmployer>> getAll();
	
	Result add(ActivationEmployer activationEmployer, User user);

	DataResult<ActivationEmployer> getByUserId(int id);

}
