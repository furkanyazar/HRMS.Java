package furkanyazar.hrms.business.abstracts;

import java.util.List;

import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.Activation;
import furkanyazar.hrms.entities.concretes.User;

public interface ActivationService {
	
	DataResult<List<Activation>> getAll();
	
	Result add(Activation activation, User user);

}
