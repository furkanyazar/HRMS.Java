package furkanyazar.hrms.business.abstracts;

import java.util.List;

import furkanyazar.hrms.core.utilities.results.DataResult;
import furkanyazar.hrms.core.utilities.results.Result;
import furkanyazar.hrms.entities.concretes.ActivationEmployer;
import furkanyazar.hrms.entities.concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();

	DataResult<List<Employer>> findByEmail(String email);

	DataResult<Boolean> confirmEmail();

	Result add(Employer employer);

	DataResult<Employer> getById(int id);

	Result setIsActivated(ActivationEmployer activationEmployer, Employer employer, Boolean isActivated, int id);

}
